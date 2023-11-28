
package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author JIVB
 */
public class BoardGraphic extends GraphicComposite {
    Rectangle2D.Double tablero;
    
    double centro=0;
    double i;
    double d;

    public BoardGraphic() {
        tablero = new Rectangle2D.Double();
    }

    @Override
    public void draw(Graphics2D g2) {
        tablero.setFrameFromDiagonal(100, 100, rec.getWidth()-100, rec.getHeight()-100);
        g2.setPaint(new Color(102, 102, 102));
        g2.fillRect(0, 0, (int)rec.getWidth(), (int)rec.getHeight());
        g2.setPaint(Color.white);
        g2.fill(tablero);
        
        dibujaTren();
        for (GraphicComponent component : components) 
            component.draw(g2);
    }

    private void dibujaTren() {
        if(!components.isEmpty())return;
        var r=new java.util.Random().nextInt(6);
        var t= new BoardTileGraphic(r,r,new Point((int)(rec.getBounds().getCenterX()-20),(int)rec.getBounds().getCenterY()-40));
        centro=t.getP().getX();
        i=centro;
        d=centro-t.rec.getWidth();
        components.add(t);
    }

    
    
    
}
