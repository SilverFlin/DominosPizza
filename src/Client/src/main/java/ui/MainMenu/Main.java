package ui.MainMenu;

import data.ModelManager;
import network.EventRouterStub;
import ui.Board.BoardJFrame;
import ui.Board.BoardPresenterImpl;
import ui.base.Model;

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

    }

}
