
package graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;


/**
 *
 * @author JIVB
 */
public abstract class GraphicComponent {
    
    protected Rectangle rec;
    
    public abstract void draw(Graphics2D g2);
}
