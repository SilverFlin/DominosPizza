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
public class NetworkEventConnection implements NetworkConnection<Event>, EventSubject {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private List<EventConsumer> observers;

    private static final Logger LOG
            = Logger.getLogger(NetworkEventConnection.class.getName());

    public NetworkEventConnection() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void startConnection(final String ip, final int port) {
        try {
            this.socket = new Socket(ip, port);
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

}
