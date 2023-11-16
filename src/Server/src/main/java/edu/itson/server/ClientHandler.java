package edu.itson.server;

import edu.itson.eventschema.Event;
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
     * Consumes an event by sending it back to the client.
     *
     * @param event The event to be consumed and sent back.
     */
    @Override
    public void consumeEvent(final Event event) {

        try {
            output.writeObject(event);
            output.flush();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error sending event back to client: " + ex.getMessage());
        }
    }

    @Override
    public void publishEvent(final Event event) {
        eventBus.sendEvent(event);
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
                } catch (IOException ex1) {
                    LOG.log(Level.SEVERE, "Error closing client socket: " + ex.getMessage());
                }
                this.eventBus.unsubscribe(this);
                LOG.log(Level.INFO, "Client socket closed");
            }

        }
    }

}
