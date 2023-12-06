package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 */
public class GameOverTableGraphic extends GraphicComposite {

    Rectangle2D.Double boardRectangle;
    double startXCoord = 620.0;
    double endXCoord = 580.0;

    public GameOverTableGraphic() {
    }

    @Override
    public void draw(Graphics2D g2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(GraphicComponent gc) {
        
        
        
        
        super.add(gc); 
    }

}
