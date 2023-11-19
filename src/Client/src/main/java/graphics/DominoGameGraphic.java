package graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author JIVB
 */
public class DominoGameGraphic extends GraphicComposite {
    
    
    public DominoGameGraphic() {
        components.add(new BoardGraphic());
        components.add(new PlayerHandGraphic());
    }
    
    public DominoGameGraphic(Rectangle bounds) {
        components.add(new BoardGraphic());
        components.add(new PlayerHandGraphic(bounds));
        setRecs(bounds);
    }

    public DominoGameGraphic(PlayerHandGraphic ph, BoardGraphic bg) {
        components.add(bg);
        components.add(ph);
    }

    @Override
    public void draw(Graphics2D g2) {
        for (var g : components) 
            g.draw(g2);
        
    }

    void setRecs(Rectangle bounds) {
        this.rec=bounds;
        for (var component : components) 
            component.rec=this.rec;    
//        var x =(PlayerHandGraphic)components.get(1);
//        x.lugaresFichas();
    }
    
    
}
