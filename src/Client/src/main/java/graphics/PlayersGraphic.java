
package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author JIVB
 */
public class PlayersGraphic extends GraphicComposite {

    @Override
    public void draw(Graphics2D g2) {
        this.rec.setFrameFromDiagonal(100, (rec.getHeight()/2)-100, rec.getWidth() - 100, (rec.getHeight()/2) + 100);
    /*    var avatarHarcodeado1 = new AvatarGraphic("awdddddd", new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB), new Point2D.Double());
        components.add(avatarHarcodeado1);
        avatarHarcodeado1 = new AvatarGraphic("eefef", new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB), new Point2D.Double());
        components.add(avatarHarcodeado1);
        avatarHarcodeado1 = new AvatarGraphic("ssss", new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB), new Point2D.Double());
        components.add(avatarHarcodeado1);
      */  
        lugaresJugadores();
        
        for (GraphicComponent component : components) {
            AvatarGraphic a = (AvatarGraphic) component;
            System.out.println(a.getName());
            System.out.println(a.getP());
            component.draw(g2);
        }
    }

    private void lugaresJugadores() {
        var lugarX=rec.getX();
        for (var component : components) {
            AvatarGraphic ag=(AvatarGraphic)component;
            ag.setP(new Point2D.Double(lugarX, rec.getY()+100));
            lugarX+=ag.getImage().getWidth()+50;
        }
    }
    
    
}
