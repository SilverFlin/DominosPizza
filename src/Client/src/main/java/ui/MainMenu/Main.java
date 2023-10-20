package ui.MainMenu;

import ui.Board.BoardJFrame;
import ui.Board.BoardPresenterImpl;

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
        MainMenuView vista = new MainMenuJFrame();

        vista.setMenuPanel(new MenuJPanel());
        vista.setAvatarPanel(new AvatarsJPanel());
        vista.setConfigurationPanel(new ConfigurationJPanel());
        vista.setLobbyPanel(new LobbyJPanel());
        MainMenuViewListener presenter = new MainMenuPresenter(vista);
        presenter.setBoardPresenter(new BoardPresenterImpl(new BoardJFrame()));
        vista.setListener(presenter);

        vista.displayMenuPanel();
        vista.load();

    }

}
