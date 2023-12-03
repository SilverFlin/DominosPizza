package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author JIVB
 */
public class GamePanel extends JPanel {

    DominoGameGraphic dominoGameGraphic;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    public GamePanel() {
        dominoGameGraphic = new DominoGameGraphic();
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        addMouseListener(new Puntero(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;
        g2.setRenderingHints(rh);
        dominoGameGraphic.setRecs(this.getBounds());
        dominoGameGraphic.draw(g2);
    }

    public void update(final DominoGameGraphic dominoGameGraphic) {
        this.dominoGameGraphic = dominoGameGraphic;
        this.repaint();
    }
}
