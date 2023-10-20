package ui.MainMenu;


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
        MainMenuJFrame vista = new MainMenuJFrame();

        vista.setMenuPanel(new MenuJPanel());
        vista.setAvatarPanel(new AvatarsJPanel());
        vista.setConfigurationPanel(new ConfigurationJPanel());
        vista.setLobbyPanel(new LobbyJPanel());
        
        vista.displayMenuPanel();
        vista.setVisible(true);

    }

}
