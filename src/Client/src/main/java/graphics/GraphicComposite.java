package graphics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIVB
 */
public abstract class GraphicComposite {

    List<GraphicComponent> components;

    public void add(GraphicComponent gc) {
        components.add(gc);
    }

    public void remove(GraphicComponent gc) {
        components.remove(gc);
    }

    public void draw() {
        for (var component : components) {
            component.draw();
        }
    }

}
