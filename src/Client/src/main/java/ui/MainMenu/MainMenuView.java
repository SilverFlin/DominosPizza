package ui.MainMenu;

import data.dominio.Avatar;
import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;
import ui.base.View;

/**
 *
 * @author Toled
 */
public interface MainMenuView extends View {

    void displayConfigurationPanel();

    void displayAvatarsPanel();

    void displayLobbyPanel();

    void displayMenuPanel();

    void displayBoardView();

    void setMenuPanel(MenuJPanel panel);

    void setAvatarPanel(AvatarsJPanel panel);

    void setConfigurationPanel(ConfigurationJPanel panel);

    void setLobbyPanel(LobbyJPanel panel);

    void setListener(MainMenuViewListener listener);

    void setTilesPerPlayer(int cant);

    void createAvatar(String name, String Image);

    Avatar getAvatar();

    void createPlayer(Avatar avatar);

    void removePlayer(Player player);

    void createDominoGame();

    void createTurnController();

    DominoGame getDominoGame();

}
