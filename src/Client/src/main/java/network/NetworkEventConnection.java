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
 * Implementación de la interfaz NetworkConnection que maneja conexiones de
 * eventos a través de sockets. Además, implementa EventSubject y Runnable para
 * observar eventos y ejecutar en un hilo separado.
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

    /**
     * Constructor de NetworkEventConnection.
     *
     * @param ip La dirección IP del servidor al que se conectará.
     * @param port El puerto al que se conectará.
     */
    public NetworkEventConnection(final String ip, final int port) {
        this.observers = new ArrayList<>();
        this.ip = ip;
        this.port = port;
    }

    /**
     * Inicia la conexión estableciendo el socket y los flujos de
     * entrada/salida.
     */
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

    /**
     * Detiene la conexión cerrando los flujos de entrada/salida y el socket.
     */
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

    /**
     * Envía un mensaje a través de la conexión.
     *
     * @param message El evento que se va a enviar.
     */
    @Override
    public void sendMessage(final Event message) {
        try {
            message.setSenderAddress(this.socket.getLocalSocketAddress().toString());
            out.writeObject(message);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error al enviar mensaje al servidor.");
        }
    }

    /**
     * Agrega un observador a la lista de observadores.
     *
     * @param observer El observador que se va a agregar.
     */
    @Override
    public void addObserver(final EventConsumer observer) {
        this.observers.add(observer);
    }

    /**
     * Elimina un observador de la lista de observadores.
     *
     * @param observer El observador que se va a eliminar.
     */
    @Override
    public void removeObserver(final EventConsumer observer) {
        this.observers.remove(observer);
    }

    /**
     * Notifica a todos los observadores sobre un evento recibido.
     *
     * @param event El evento que se va a notificar a los observadores.
     */
    @Override
    public void notifyObservers(final Event event) {
        for (EventConsumer observer : observers) {
            observer.consumeEvent(event);
        }
    }

    /**
     * Implementación del método run de la interfaz Runnable. Se encarga de
     * recibir eventos continuamente y notificar a los observadores.
     */
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
