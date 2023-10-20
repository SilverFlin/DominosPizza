package ui.MainMenu;

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
}
