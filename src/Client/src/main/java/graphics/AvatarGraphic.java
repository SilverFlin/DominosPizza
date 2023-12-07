
package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author JIVB
 */
public class AvatarGraphic extends GraphicComponent {
    
    private String name;
    private BufferedImage image;
    private Point2D p;
    
    public AvatarGraphic(String name, BufferedImage image) {
        super();
        this.name = name;
        this.image = image;
    }

    public AvatarGraphic(String name, BufferedImage image,Point2D p) {
        super();
        this.name = name;
        this.image = image;
        this.p=p;
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

    public Point2D getP() {
        return p;
    }

    public void setP(Point2D p) {
        this.p = p;
    }
    
    

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image, null, (int)p.getX(), (int)p.getY());
        g2.drawString(name, (int)p.getX(), (int)p.getY()+image.getHeight()+5);
    }
    
}
