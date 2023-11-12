package client;

import interfaces.GameSystemFacade;
import network.EventManager;
import network.NetworkEventConnection;

/**
 * Clase principal de la aplicación.
 */
public class App {

    public static void main(String[] args) {
        // TODO
        // Crear GameSystemFacade
        GameSystemFacade gameSystemFacade = new GameSystemFacadeImpl();

        // Crear Event Manager
        NetworkEventConnection eventConnection = new NetworkEventConnection("127.0.0.1", 6666);
        EventManager eventManager = new EventManager(eventConnection, gameSystemFacade);

        // Crear Presentadores
        // TODO: Crear instancias de los presentadores (por ejemplo, MainMenuPresenter y GamePresenter)
        // Pasarle el Producer a los presentadores
        // TODO: Settear el EventManager como el EventProducer para los presentadores
        // Settear presentadores al gamesystem
        // TODO: Settear los presentadores al GameSystemFacade
        // Iniciar hilo de la conexión.
        Thread eventConnectionThread = new Thread(eventConnection);
        eventConnectionThread.start();
    }

}
