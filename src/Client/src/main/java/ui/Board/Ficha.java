
package ui.Board;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class Ficha {
    
    BufferedImage imagen;
    Rectangle2D.Double rec= new Rectangle2D.Double(0,0,40,80);

    public Ficha() {
    }
    
    public Ficha(BufferedImage imagen){
        this.imagen=imagen;
    }

    public Ficha(BufferedImage imagen, int x, int y) {
        this.imagen = imagen;
        rec=new Rectangle2D.Double(x,y,40,80);
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }


    public Rectangle2D.Double getRec() {
        return rec;
    }

    public void setRec(Rectangle2D.Double rec) {
        this.rec = rec;
    }
    
    
    
    
    
    
    
}
