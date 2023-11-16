package graphics;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIVB
 */
public abstract class GraphicComposite {

    List<GraphicComponent> components;

    public GraphicComposite() {
        components=new ArrayList<>();
    }

    public void add(GraphicComponent gc) {
        components.add(gc);
    }

    public void remove(GraphicComponent gc) {
        components.remove(gc);
    }

    public void draw(Graphics2D g2) {
        for (var component : components) 
            component.draw(g2);
        
    }

}
