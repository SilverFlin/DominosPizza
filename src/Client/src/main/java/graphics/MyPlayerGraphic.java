
package graphics;

import java.awt.Graphics2D;

/**
 *
 * @author JIVB
 */
public class MyPlayerGraphic extends GraphicComposite {
    
    

    public MyPlayerGraphic() {
    }
    
    
    @Override
    public void draw(Graphics2D g2) {
        for (var component : components) 
            component.draw(g2);
    }
    
    
    
}
