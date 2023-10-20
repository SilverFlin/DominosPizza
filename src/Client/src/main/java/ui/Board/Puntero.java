
package ui.Board;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class Puntero implements MouseInputListener {
    
    Board b;
    

    public Puntero(Board b) {
        this.b=b;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        b.p.setLocation(e.getPoint());
        
        
        
        for(var f:b.principal.getFichas())
            if(f.getRec().contains(e.getPoint()))
                b.principal.selecionada=f;
        
        if(b.principal.selecionada!=null && b.tablero.contains(e.getPoint())){
            var t =b.principal.selecionada;
            t.setRec(new Rectangle2D.Double(e.getPoint().getX()-20, e.getPoint().getY()-40, t.getRec().getWidth(), t.getRec().getHeight()));
            b.usadas.add(t);
            b.principal.getFichas().remove(t);
            b.principal.selecionada=null;
        }
        
            
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //b.presionado = e.getButton() != MouseEvent.BUTTON1;
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
        b.p.setLocation(e.getPoint());
    }
    
}
