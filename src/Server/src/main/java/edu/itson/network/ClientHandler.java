package edu.itson.network;

import domain.DominoGame;
import domain.Player;
import domain.Pool;
import edu.itson.eventschema.Event;
import edu.itson.events.EventBus;
import edu.itson.events.EventConsumer;
import edu.itson.events.EventProducer;
import edu.itson.eventschema.PlayerJoinsEvent;
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
     * Consume un evento, enviandolo de regreso al cliente.
     *
     * @param event El evento a consumir.
     */
    @Override
    public void consumeEvent(final Event event) {
        
        try {
            LOG.log(Level.INFO, "ID Client " + this.idClient + ": consumed " + event);
            if (event instanceof PlayerJoinsEvent evt) {
                Player player = evt.getPayload();
                DominoGame dominoGame = new DominoGame();
                if (this.idClient == 0) {
                    LOG.log(Level.INFO, "Admin ready");
                    player.setIsAdmin(true);
                    Pool pool = new Pool();
                    pool.setDominoes(DominioUtils.createAllTiles());
                    dominoGame.setPool(pool);
                }
                Server.addPlayer(player);
                dominoGame.setPlayers(Server.getPlayers());
                UpdateWaitingRoomEvent updateWaitingRoomEvent = new UpdateWaitingRoomEvent(dominoGame);
                
                output.writeObject(updateWaitingRoomEvent);
                output.flush();
                return;
            }
            output.writeObject(event);
            output.flush();
            
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error sending event back to client: " + ex.getMessage());
        }
    }
    
    @Override
    public void publishEvent(final Event event) {
        this.eventBus.sendEvent(event);
    }
    
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
                    clientSocket.close();
                    this.eventBus.unsubscribe(this);
                    LOG.log(Level.INFO, "Client socket closed");
                } catch (IOException ex1) {
                    LOG.log(Level.SEVERE, "Error closing client socket: " + ex.getMessage());
                }
            }
            
        }
    }
    
}
