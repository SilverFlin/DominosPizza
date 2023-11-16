
package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author JIVB
 */
public class BoardGraphic extends GraphicComposite {
    int w=1280,h=600;
    Rectangle2D.Double tablero;

    public BoardGraphic() {
        tablero = new Rectangle2D.Double();
        tablero.setFrameFromDiagonal(100, 100, w-100, h-100);
        this.components = new ArrayList<>();
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setPaint(new Color(102, 102, 102));
        g2.fillRect(0, 0, w, h);
        g2.setPaint(Color.white);
        g2.fill(tablero);
    }

    
    
    
}
