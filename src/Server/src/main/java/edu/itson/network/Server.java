package edu.itson.network;

import domain.Player;
import edu.itson.network.ClientHandler;
import edu.itson.events.EventBus;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa un servidor que maneja conexiones de clientes.
 */
public class Server {

    private final int port;
    private final int maxClients;
    private static volatile List<ClientHandler> clients = new ArrayList<>();
    private static volatile List<Player> players = Collections.synchronizedList(new ArrayList<>());

    private static final Logger LOG = Logger.getLogger(Server.class.getName());

    /**
     * Constructor de la clase Server.
     *
     * @param PORT El puerto en el que el servidor escuchará.
     * @param MAX_CLIENTS El número máximo de clientes que el servidor puede
     * manejar.
     */
    public Server(final int PORT, final int MAX_CLIENTS) {
        this.port = PORT;
        this.maxClients = MAX_CLIENTS;
    }

    /**
     * Inicia el servidor y espera conexiones de clientes.
     */
    public void startServer() {
        ExecutorService executor = Executors.newFixedThreadPool(maxClients);
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            LOG.log(Level.INFO, "Server started. Listening for clients...\n");

            while (true) {
                ClientHandler clientHandler = this.handleClient(serverSocket);
                executor.execute(clientHandler);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Error at starting the server" + e + "\n");
        } finally {
            LOG.log(Level.INFO, "Server stopped. \n");
            executor.shutdown();
        }

    }

    /**
     * Maneja la conexión de un nuevo cliente.
     *
     * @param serverSocket El socket del servidor.
     * @return El manejador de cliente creado.
     */
    public ClientHandler handleClient(final ServerSocket serverSocket) {
        ClientHandler clientHandler = null;
        try {
            Socket clientSocket = serverSocket.accept();
            clientHandler = new ClientHandler(clientSocket, EventBus.getInstance());
            clientHandler.setIdClient(Server.clients.size());
            EventBus.getInstance().subscribe(clientHandler);
            Server.clients.add(clientHandler);
            LOG.log(Level.INFO, "New client connected: " + clientSocket.getInetAddress().getHostAddress() + "\n");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error at handling client" + ex + "\n");
        }
        return clientHandler;
    }

    /**
     * Obtiene la lista de clientes conectados al servidor.
     *
     * @return Lista de clientes.
     */
    public synchronized List<ClientHandler> getClients() {
        return clients;
    }

    public synchronized static int getClientsSize() {
        return clients.size();
    }

    public static synchronized void addPlayer(final Player element) {
        Server.players.add(element);

    }

    public static synchronized List<Player> getPlayers() {
        return new ArrayList<>(Server.players);
    }

}
