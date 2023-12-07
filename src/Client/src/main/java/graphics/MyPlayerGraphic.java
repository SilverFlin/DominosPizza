package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import graphics.AvatarGraphic;

/**
 *
 * @author JIVB
 */
public class MyPlayerGraphic extends GraphicComposite {

    public MyPlayerGraphic() {
    }

    @Override
    public void draw(Graphics2D g2) {

        this.rec.setFrameFromDiagonal(100, (rec.getHeight() / 2) - 100, rec.getWidth() - 100, (rec.getHeight() / 2) - 100 + 100);
        //var avatarHardcodeado =new AvatarGraphic("Jugador principal",new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB), new Point2D.Double(this.rec.getX(),this.rec.getY()-110));
        //components.add(avatarHardcodeado);
        for (GraphicComponent component : this.components) {
            AvatarGraphic av = (AvatarGraphic) component;
            av.setP(new Point2D.Double(this.rec.getX(), this.rec.getY() - 110));
            component.draw(g2);
        }
    }

}
