
package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 *
 * @author JIVB
 */
public class PlayerTileGraphic extends GraphicComponent {
    
    int leftNum;
    int rightNum;
    Point2D p;

    public PlayerTileGraphic() {
    }

    public PlayerTileGraphic(int leftNum, int rightNum,Point2D p) {
        this.leftNum = leftNum;
        this.rightNum = rightNum;
        this.p=p;
    }

    public void setP(Point2D p) {
        this.p = p;
    }

    @Override
    public void draw(Graphics2D g2) {
        var t=new Tile(leftNum,rightNum,(int)p.getX(),(int)p.getY());
        g2.drawImage(t.getImagen(), null,
                    (int) t.recTile.getX(),
                    (int) t.recTile.getY());
    }
    
}
