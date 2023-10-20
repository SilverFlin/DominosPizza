package ui.MainMenu;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import ui.base.BasePanel;

/**
 *
 */
public class MainMenuJFrame extends javax.swing.JFrame implements MainMenuView {

    private AvatarsJPanel avatarPanel;
    private LobbyJPanel lobbyPanel;
    private ConfigurationJPanel<MainMenuJFrame> configurationPanel;
    private MenuJPanel menuPanel;
    private final List<JPanel> panels = new LinkedList<>();

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

    @Override
    public void setAvatarPanel(final AvatarsJPanel avatarPanel) {
        this.avatarPanel = avatarPanel;
        this.addPanel(avatarPanel);
        this.avatarPanel.setView(this);
    }

    @Override
    public void displayAvatarsPanel() {
        this.hidePanels();
        this.avatarPanel.setVisible(true);
    }

    @Override
    public void setLobbyPanel(final LobbyJPanel lobbyPanel) {
        this.lobbyPanel = lobbyPanel;
        this.addPanel(lobbyPanel);
        this.lobbyPanel.setView(this);
    }

    @Override
    public void displayLobbyPanel() {
        this.hidePanels();
        this.lobbyPanel.setVisible(true);
    }

    @Override
    public void setConfigurationPanel(final ConfigurationJPanel configurationPanel) {
        this.configurationPanel = configurationPanel;
        this.addPanel(configurationPanel);
        this.configurationPanel.setView(this);
    }

    @Override
    public void displayConfigurationPanel() {
        this.hidePanels();
        this.configurationPanel.setVisible(true);
    }

    @Override
    public void setMenuPanel(final MenuJPanel menuPanel) {
        this.menuPanel = menuPanel;
        this.addPanel(menuPanel);
        this.menuPanel.setView(this);

    }

    @Override
    public void displayMenuPanel() {
        this.hidePanels();
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
    public void load() {
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
