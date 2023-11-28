package edu.itson.server;

import edu.itson.network.Server;

/**
 * Punto de entrada principal de la aplicación.
 */
public class App {

    /**
     * Método principal que inicia el servidor.
     *
     * @param args
     */
    public static void main(String[] args) {

        Server server = new Server(6666, 4);

        server.startServer();

    }
}
