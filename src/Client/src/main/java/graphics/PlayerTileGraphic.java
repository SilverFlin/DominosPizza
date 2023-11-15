
package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 *
 * @author JIVB
 */
public class PlayerTileGraphic implements GraphicComponent {
    
    Tile tile;
    Point2D point;
    Graphics2D g2;

    public PlayerTileGraphic() {
    }

    public PlayerTileGraphic(Tile tile, Graphics2D g2) {
        this.tile = tile;
        this.g2=g2;
        point = new Point2D.Double(tile.getRec().getX(), tile.getRec().getY());
    }

    public PlayerTileGraphic(Tile tile, Point2D point,Graphics2D g2) {
        this.tile = tile;
        this.point = point;
        this.g2=g2;
    }
    

    @Override
    public void draw() {
        g2.drawImage(tile.getImagen(), null,
                    (int) point.getX(),
                    (int) point.getY());
    }
    
}
