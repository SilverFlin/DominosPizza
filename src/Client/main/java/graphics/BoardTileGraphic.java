package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;



/**
 *
 * @author JIVB
 */
public class BoardTileGraphic extends GraphicComponent
{
    int leftNum;
    int rightNum;
    Point2D p;

    public BoardTileGraphic(int leftNum, int rightNum, Point2D p) {
        this.leftNum = leftNum;
        this.rightNum = rightNum;
        this.p = p;
        var t=new Tile(leftNum,rightNum,(int)p.getX(),(int)p.getY());
        rec=t.recTile.getBounds();
    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public int getRightNum() {
        return rightNum;
    }

    public void setRightNum(int rightNum) {
        this.rightNum = rightNum;
    }

    public Point2D getP() {
        return p;
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
