
package graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author JIVB
 */
public class AvatarGraphic implements GraphicComponent {
    
    private String name;
    private BufferedImage image;

    public AvatarGraphic(String name, BufferedImage image) {
        super();
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void draw() {

    }
    
}
