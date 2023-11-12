package ui.MainMenu;

import domain.DominoGame;
import domain.Player;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import ui.Board.BoardJFrame;
import ui.Board.GamePresenter;
import ui.Board.GamePresenterImpl;

/**
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // TODO use MainMenuView
//        MainMenuView vista = new MainMenuJFrame();
//
//        vista.setMenuPanel(new MenuJPanel());
//        vista.setAvatarPanel(new PlayerSetupPanel());
//        vista.setConfigurationPanel(new ConfigurationJPanel());
//        vista.setLobbyPanel(new WaitingRoomJPanel());
//        
//        MainMenuViewListener presenter = new MainMenuPresenter(vista);
//        presenter.setEventRouter(new EventRouterStub());
//        Model model = new ModelManager();
//        presenter.setModel(model);
//        presenter.setBoardPresenter(new BoardPresenterImpl(new BoardJFrame()));
//        vista.setListener(presenter);
//
//        vista.displayMenuPanel();
//        vista.load();
        MainMenuView view = new MainMenuJFrame();
        view.setMenuPanel(new MenuJPanel());
        view.setPlayerSetupPanel(new PlayerSetupPanel());
        view.setWaitingRoomPanel(new WaitingRoomJPanel());

        List<AvatarDTO> avatars = new ArrayList<>();
        avatars.add(new AvatarDTO("", "123"));
        avatars.add(new AvatarDTO("", "dfs"));
        avatars.add(new AvatarDTO("", "12hj,h3"));
        avatars.add(new AvatarDTO("", "<zx"));
        avatars.add(new AvatarDTO("", "12dg3"));
        MainMenuModel model = new MainMenuModelImpl(DominoGame.getInstance(), avatars);

        Router router = new RouterImpl(new LinkedList<>());

        GamePresenter gamePresenter = new GamePresenterImpl();

        MainMenuPresenter presenter = new MainMenuPresenterImpl(view, model, router, gamePresenter);
        view.setPresenter(presenter);
        router.setMainMenuPresenter(presenter);

        view.displayMenuPanel();
        view.load();
    }

}
