package graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author JIVB
 */
public final class DominoGameGraphic extends GraphicComposite {

    public DominoGameGraphic() {
        components.add(new BoardGraphic());
        components.add(new PlayerHandGraphic());
        components.add(new ScoreBoard());
    }

    public DominoGameGraphic(final PlayerHandGraphic ph, final BoardGraphic bg) {
        components.add(bg);
        components.add(ph);
    }

    @Override
    public void draw(Graphics2D g2) {
        for (var g : components) {
            g.draw(g2);
        }

    }

    public void setRecs(Rectangle bounds) {
        this.rec = bounds;
        for (var component : components) {
            component.rec = this.rec;
        }
    }

}
