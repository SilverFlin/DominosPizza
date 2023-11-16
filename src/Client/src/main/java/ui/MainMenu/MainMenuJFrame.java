package ui.MainMenu;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 */
public class MainMenuJFrame extends javax.swing.JFrame implements MainMenuView, ViewParent {

    private PlayerSetupPanel playerSetupPanel;
    private WaitingRoomJPanel waitingRoomPanel;
    private MenuJPanel menuPanel;
    private final List<JPanel> panels = new LinkedList<>();
    private MainMenuPresenter presenter;

    private static final int PANEL_START_X = 0;
    private static final int PANEL_START_Y = 0;
    private static final int FRAME_WIDTH = 1280;
    private static final int FRAME_HEIGHT = 800;

    private static final AbsoluteConstraints CONSTRAINTS
            = new AbsoluteConstraints(
                    PANEL_START_X,
                    PANEL_START_Y,
                    FRAME_WIDTH,
                    FRAME_HEIGHT
            );

    /**
     * Creates new form MainMenuJFrame
     */
    public MainMenuJFrame() {
        initComponents();
    }

    public void addPanel(final JPanel panel) {
        if (!this.panels.contains(panel)) {
            this.panels.add(panel);
        }
        this.add(panel, CONSTRAINTS);
        panel.setVisible(false);
    }

//    @Override
    @Override
    public void setPlayerSetupPanel(final PlayerSetupPanel playerSetupPanel) {
        this.playerSetupPanel = playerSetupPanel;
        this.addPanel(playerSetupPanel);
        this.playerSetupPanel.setView(this);
    }
//
//    @Override

    @Override
    public void displayPlayerSetupPanel() {
        this.hidePanels();
        this.playerSetupPanel.setVisible(true);
    }
//
//    @Override

    @Override
    public void setWaitingRoomPanel(final WaitingRoomJPanel waitingRoomPanel) {
        this.waitingRoomPanel = waitingRoomPanel;
        this.addPanel(waitingRoomPanel);
        this.waitingRoomPanel.setView(this);
    }

    @Override
    public void setPresenter(MainMenuPresenter presenter) {
        this.presenter = presenter;

        for (JPanel panel : panels) {
            if (panel instanceof ViewParent) {
                ((ViewParent) panel).setPresenter(presenter);
            }
        }
    }

//
//    @Override
//    public void displayLobbyPanel() {
//        this.hidePanels();
//        this.lobbyPanel.setVisible(true);
//        
//    }
//
//    @Override
//    public void setConfigurationPanel(final ConfigurationJPanel configurationPanel) {
//        this.configurationPanel = configurationPanel;
//        this.addPanel(configurationPanel);
//        this.configurationPanel.setView(this);
//    }
//
    @Override
    public void displayWaitingRoomPanel() {
        this.hidePanels();
        this.waitingRoomPanel.setVisible(true);
    }
//
//    @Override

    @Override
    public void setMenuPanel(final MenuJPanel menuPanel) {
        this.menuPanel = menuPanel;
        this.addPanel(menuPanel);
        this.menuPanel.setView(this);

    }
//
//    @Override

    @Override
    public void displayMenuPanel() {
        this.hidePanels();
        System.out.println("Display Menu");
        this.menuPanel.setVisible(true);
    }

    private void hidePanels() {
        for (JPanel panel : panels) {
            panel.setVisible(false);
            panel.revalidate();
            panel.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("all")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void open() {
        this.setVisible(true);
        this.displayMenuPanel();
    }

    @Override
    public void updateWaitingRoom(MainMenuViewModel viewModel) {
        updateWaitingRoom(viewModel);
    }

    @Override
    public void showLobbyPanel(MainMenuViewModel viewModel) {

        this.displayWaitingRoomPanel();
        this.waitingRoomPanel.updateWaitingRoom(viewModel);

    }

    @Override
    public void showInvalidNameError() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showAvatarPanel(MainMenuViewModel viewModel) {
        this.displayPlayerSetupPanel();
        this.playerSetupPanel.updateAvatarPanel(viewModel);
    }

//    @Override
    @Override
    public void load() {
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
//
//    @Override
//    public void displayBoardView() {
//        this.listener.onGameReadyButton();
//    }
//
//    @Override
//    public void close() {
//        this.dispose();
//    }
//
//    @Override
//    public void setListener(final MainMenuViewListener listener) {
//        this.listener = listener;
//    }
//
//    @Override
//    public void setTilesPerPlayer(int cant) {
//        listener.setTilesPerPlayer(cant);
//    }
//
//    @Override
//    public void createAvatar(String name, String Image) {
//        listener.createAvatar(name, Image);
//    }
//
//    @Override
//    public Avatar getAvatar() {
//        return listener.getAvatar();
//    }
//
//    @Override
//    public void createPlayer(Avatar avatar) {
//        listener.createPlayer(avatar);
//    }
//
//    @Override
//    public void removePlayer(Player player) {
//        listener.removePlayer(player);
//    }
//
//    @Override
//    public void createDominoGame() {
//        listener.createDominoGame();
//    }
//
//    @Override
//    public void createTurnController() {
//        listener.createTurnController();
//    }
//
//    @Override
//    public DominoGame getDominoGame() {
//        return listener.getDominoGame();
//    }
//
//    @Override
//    public void startGameFromMenu() {
//        this.listener.onStartGameButton();
//    }
//
//    @Override
//    public void updatePlayers(final List<Player> players) {
////        this.lobbyPanel.updatePlayers();
//        System.out.println("TODO");
//    }
//
//    @Override
//    public void notifyPlayers() {
//        this.listener.notifyPlayers();
//    }
//
//    @Override
//    public void toggleReadyStatus() {
//        this.listener.toggleReadyStatus();
//    }

    @Override
    public void foreStart() {
        this.presenter.foreStart();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
