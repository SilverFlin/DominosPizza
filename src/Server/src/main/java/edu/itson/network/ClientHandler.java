package edu.itson.network;

import domain.DominoGame;
import domain.Player;
import domain.Pool;
import edu.itson.eventschema.Event;
import edu.itson.events.EventBus;
import edu.itson.events.EventConsumer;
import edu.itson.events.EventProducer;
import edu.itson.eventschema.PlayerJoinsEvent;
import edu.itson.eventschema.PlayerLeaveEvent;
import edu.itson.eventschema.UpdateWaitingRoomEvent;
import edu.itson.utils.DominioUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja la comunicación con un cliente.
 */
public class ClientHandler implements EventConsumer, EventProducer, Runnable {

    private final Socket clientSocket;
    private final EventBus eventBus;
    private final ObjectInputStream input;
    private final ObjectOutputStream output;
    private int idClient;

    public void setIdClient(final int idClient) {
        this.idClient = idClient;
    }

    private static final Logger LOG = Logger.getLogger(ClientHandler.class.getName());

    /**
     * Constructor de la clase ClientHandler.
     *
     * @param clientSocket El socket del cliente.
     * @param eventBus El EventBus utilizado para la comunicación.
     * @throws IOException Si hay un error de entrada/salida.
     */
    public ClientHandler(final Socket clientSocket, final EventBus eventBus) throws IOException {
        this.clientSocket = clientSocket;
        this.eventBus = eventBus;
        this.input = new ObjectInputStream(this.clientSocket.getInputStream());
        this.output = new ObjectOutputStream(this.clientSocket.getOutputStream());
    }

    /**
     * Consume un evento, enviándolo de regreso al cliente.
     *
     * @param event El evento a consumir.
     */
    @Override
    public void consumeEvent(final Event event) {

        try {
            if (event instanceof PlayerJoinsEvent evt) {
                this.handlePlayerJoinsEvent(evt);
                return;
            } else if (event instanceof PlayerLeaveEvent evt) {
                this.handlePlayerLeaveEvent(evt);
                return;
            }

            if (this.isSameProducer(event)) {
                LOG.log(Level.INFO, "Ignoring auto-event\n");
                return;
            }
            output.writeObject(event);
            output.flush();

        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error sending event back to the client: " + ex.getMessage() + "\n");
        }
    }

    /**
     * Publica un evento en el EventBus.
     *
     * @param event El evento a publicar.
     */
    @Override
    public synchronized void publishEvent(final Event event) {
        this.eventBus.sendEvent(event);
    }

    /**
     * Método principal que se ejecuta en un hilo separado.
     */
    @Override
    public void run() {
        Object receivedObject;
        while (!this.clientSocket.isClosed()) {
            try {
                receivedObject = this.input.readObject();
                if (receivedObject instanceof Event message) {
                    this.publishEvent(message);
                }
            } catch (IOException | ClassNotFoundException ex) {
                LOG.log(Level.SEVERE, "Error processing client request: " + ex.getMessage());
                try {
                    this.clientSocket.close();
                    this.eventBus.unsubscribe(this);
                    LOG.log(Level.INFO, "Client socket closed");
                } catch (IOException ex1) {
                    LOG.log(Level.SEVERE, "Error closing the client socket: " + ex.getMessage());
                }
            }

        }
    }

    /**
     * Verifica si el evento tiene el mismo productor.
     *
     * @param event El evento a verificar.
     * @return true si el evento tiene el mismo productor, false de lo
     * contrario.
     */
    private boolean isSameProducer(final Event event) {
        return event != null
                && event.getSenderAddress()
                        .equals(this.clientSocket.getRemoteSocketAddress().toString());
    }

    /**
     * Maneja el evento de unirse de un jugador.
     *
     * @param evt El evento de unirse del jugador.
     * @throws IOException Si hay un error de entrada/salida.
     */
    private void handlePlayerJoinsEvent(final PlayerJoinsEvent evt) throws IOException {
        Player player = evt.getPayload();
        DominoGame dominoGame = new DominoGame();
        if (Server.getClientsSize() == 1) {
            LOG.log(Level.INFO, "Admin ready\n");
            player.setIsAdmin(true);
            Pool pool = new Pool();
            pool.setDominoes(DominioUtils.createAllTiles());
            dominoGame.setPool(pool);
        }
        if (!Server.getPlayers().contains(player)) {
            Server.addPlayer(player);
        }
        dominoGame.setPlayers(Server.getPlayers());
        UpdateWaitingRoomEvent updateWaitingRoomEvent = new UpdateWaitingRoomEvent(dominoGame);

        output.writeObject(updateWaitingRoomEvent);
        output.flush();
    }

    /**
     * Maneja el evento de salir de un jugador.
     *
     * @param evt El evento de salir del jugador.
     * @throws IOException Si hay un error de entrada/salida.
     */
    private void handlePlayerLeaveEvent(final PlayerLeaveEvent evt) throws IOException {

        if (!this.isSameProducer(evt)) {
            output.writeObject(evt);
            output.flush();
            return;
        }

        Player player = evt.getPayload();
        if (Server.getPlayers().contains(player)) {
            Server.removePlayer(player);
        }
        Server.removeClient(this);
        this.eventBus.unsubscribe(this);
        this.clientSocket.close();
        LOG.log(Level.INFO, "Client socket closed");

    }

}
