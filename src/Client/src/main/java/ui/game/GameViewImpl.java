package ui.game;

import graphics.DominoGameGraphic;
import graphics.GamePanel;
import graphics.Utils;
import ui.game.GameView;

/**
 *
 */
public class GameViewImpl extends javax.swing.JFrame implements GameView {

    private GamePresenter presenter;

    /**
     * Creates new form FramePrueba
     */
    public GameViewImpl() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new graphics.GamePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(gamePanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private graphics.GamePanel gamePanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showInvalidMoveError() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateGame(final GameViewModel gameViewModel) {
        DominoGameGraphic dominoGameGraphic = Utils.createDominoGameGraphic(gameViewModel);

        this.remove(this.gamePanel);
        this.gamePanel = new GamePanel(dominoGameGraphic);
        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(this.gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        this.add(this.gamePanel, java.awt.BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void open() {
        this.setVisible(true);
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPresenter(final GamePresenter presenter) {
        this.presenter = presenter;
    }
}
