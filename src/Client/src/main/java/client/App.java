package client;

import domain.DominoGame;
import interfaces.GameSystemFacade;
import java.util.ArrayList;
import network.EventManager;
import network.NetworkEventConnection;
import ui.MainMenu.MainMenuJFrame;
import ui.MainMenu.MainMenuModelImpl;
import ui.MainMenu.MainMenuPresenter;
import ui.MainMenu.MainMenuPresenterImpl;
import ui.game.GameModelmpl;
import ui.game.GamePresenter;
import ui.game.GamePresenterImpl;
import ui.game.GameViewStub;

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
        GamePresenter gamePresenter =  new GamePresenterImpl(new GameViewStub(), new GameModelmpl(), eventManager);
        // TODO: Agregar paneles a MainMenuJFrame
        MainMenuPresenter mainMenuPresenter = new MainMenuPresenterImpl(new MainMenuJFrame(), new MainMenuModelImpl(DominoGame.getInstance(), new ArrayList<>()), eventManager, gamePresenter);
        
        // Settear en Facade
        gameSystemFacade.setGamePresenter(gamePresenter);
        gameSystemFacade.setMainMenuPresenter(mainMenuPresenter);
        
        // Iniciar hilo de la conexión.
        Thread eventConnectionThread = new Thread(eventConnection);
        eventConnectionThread.start();
        
    }

}
