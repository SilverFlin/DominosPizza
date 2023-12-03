package client;

import domain.DominoGame;
import dtos.AvatarDTO;
import graphics.GameViewImpl;
import interfaces.GameSystemFacade;
import java.util.ArrayList;
import java.util.List;
import network.EventManager;
import network.NetworkEventConnection;
import ui.MainMenu.MainMenuJFrame;
import ui.MainMenu.MainMenuModel;
import ui.MainMenu.MainMenuModelImpl;
import ui.MainMenu.MainMenuPresenter;
import ui.MainMenu.MainMenuPresenterImpl;
import ui.MainMenu.MainMenuView;
import ui.MainMenu.MenuJPanel;
import ui.MainMenu.PlayerSetupPanel;
import ui.MainMenu.WaitingRoomJPanel;
import ui.game.GameModel;
import ui.game.GameModelmpl;
import ui.game.GamePresenter;
import ui.game.GamePresenterImpl;
import ui.game.GameView;
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
        // GamePresenter
        GameView gameView = new GameViewImpl();
        GameModel gameModel = new GameModelmpl();
        GamePresenter gamePresenter = new GamePresenterImpl(gameView, gameModel, eventManager);

        // MainMenuPresenter
        MainMenuView mainMenuView = new MainMenuJFrame();
        MenuJPanel menuJPanel = new MenuJPanel();
        mainMenuView.setMenuPanel(menuJPanel);
        PlayerSetupPanel playerSetupPanel = new PlayerSetupPanel();
        mainMenuView.setPlayerSetupPanel(playerSetupPanel);
        WaitingRoomJPanel waitingRoomJPanel = new WaitingRoomJPanel();
        mainMenuView.setWaitingRoomPanel(waitingRoomJPanel);
        // TODO: Agregar paneles a MainMenuJFrame
        List<AvatarDTO> avatars = createFakeAvatars();
        MainMenuModel mainMenuModel = new MainMenuModelImpl(new DominoGame(), avatars);
        MainMenuPresenter mainMenuPresenter = new MainMenuPresenterImpl(mainMenuView, mainMenuModel, eventManager, gamePresenter);
        mainMenuView.setPresenter(mainMenuPresenter);

        // Settear en Facade
        gameSystemFacade.setGamePresenter(gamePresenter);
        gameSystemFacade.setMainMenuPresenter(mainMenuPresenter);

        // Iniciar hilo de la conexión.
        Thread eventConnectionThread = new Thread(eventConnection);
        eventConnectionThread.start();

    }

    public static List<AvatarDTO> createFakeAvatars() {
        return new ArrayList<>(List.of(
                new AvatarDTO("AAA", "AAA.png"),
                new AvatarDTO("BBB", "BBB.png"),
                new AvatarDTO("CCC", "CCC.png"),
                new AvatarDTO("DDD", "DDD.png"),
                new AvatarDTO("EEE", "EEE.png")
        ));
    }

}
