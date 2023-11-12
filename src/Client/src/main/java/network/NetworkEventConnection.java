package network;

import edu.itson.eventschema.Event;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class NetworkEventConnection implements NetworkConnection<Event>, EventSubject, Runnable {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private final List<EventConsumer> observers;
    private final String ip;
    private final int port;

    private static final Logger LOG
            = Logger.getLogger(NetworkEventConnection.class.getName());

    public NetworkEventConnection(final String ip, final int port) {
        this.observers = new ArrayList<>();
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void startConnection() {
        try {
            this.socket = new Socket(this.ip, this.port);
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stopConnection() {
        try {
            in.close();
            out.close();
            this.socket.close();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendMessage(final Event message) {
        try {
            out.writeObject(message);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addObserver(final EventConsumer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObsever(final EventConsumer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(final Event event) {
        for (EventConsumer observer : observers) {
            observer.consumeEvent(event);
        }
    }

    @Override
    public void run() {

        this.startConnection();
        LOG.log(Level.INFO, "Connection ready");

        Event input;

        try {
            while ((input = (Event) in.readObject()) != null) {
                notifyObservers(input);
            }
        } catch (IOException | ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, "Error at handling socket message: " + ex);
        }

    }
}
