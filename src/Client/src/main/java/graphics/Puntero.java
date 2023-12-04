package graphics;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author JIVB
 */
public class Puntero implements MouseInputListener {

    GamePanel gamePanel;

    public Puntero() {
    }

    public Puntero(final GamePanel gp) {
        this.gamePanel = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(final MouseEvent e) {
        selecionar(e);
        colocar(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void selecionar(MouseEvent e) {
        var playerHandGraphic = (PlayerHandGraphic) gamePanel.dominoGameGraphic.components.get(1);
        for (var playerTiles : playerHandGraphic.components) {
            if (playerTiles.rec.contains(e.getPoint())) {
                playerHandGraphic.setSelecionada((PlayerTileGraphic) playerTiles);
                gamePanel.repaint();
            }
        }
    }

    private void colocar(MouseEvent evt) {
        var playerHandGraphic = (PlayerHandGraphic) gamePanel.dominoGameGraphic.components.get(1);
        var boardGraphic = (BoardGraphic) gamePanel.dominoGameGraphic.components.get(0);
        if (playerHandGraphic.getSelecionada() == null || !boardGraphic.boardRectangle.contains(evt.getPoint())) {
            // Ninguna ficha seleccionada
            return;
        }

        var selectedTile = playerHandGraphic.getSelecionada();

        // Se seleccionó lado derecho 
        if (boardGraphic.center > evt.getX()) {
            boardGraphic.startXCoord -= selectedTile.rec.getWidth() - 10;

            // Le asigna coordenadas, según su orientación.
            if (selectedTile.leftNum == selectedTile.rightNum) {
                selectedTile.setP(new Point((int) boardGraphic.startXCoord, (int) gamePanel.getHeight() / 2 - 40));
            } else {
                selectedTile.setP(new Point((int) boardGraphic.startXCoord, (int) gamePanel.getHeight() / 2 - 20));
            }

        } else if (boardGraphic.center < evt.getX()) {
            selectedTile.setP(selectedTile.p);
            boardGraphic.endXCoord += selectedTile.rec.getWidth();

            // Le asigna coordenadas, según su orientación.
            if (selectedTile.leftNum == selectedTile.rightNum) {
                selectedTile.setP(new Point((int) (boardGraphic.endXCoord + selectedTile.rec.getWidth()), (int) gamePanel.getHeight() / 2 - 40));
            } else {
                selectedTile.setP(new Point((int) boardGraphic.endXCoord, (int) gamePanel.getHeight() / 2 - 20));
            }

        }
        boardGraphic.add(selectedTile);
        playerHandGraphic.setSelecionada(null);
        playerHandGraphic.components.remove(selectedTile);

        gamePanel.repaint();
    }

}
