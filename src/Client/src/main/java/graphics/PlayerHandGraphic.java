
package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;


/**
 *
 * @author JIVB
 */
public class PlayerHandGraphic extends GraphicComposite {
    
    private PlayerTileGraphic selecionada;

    public PlayerHandGraphic() {
        
    }

    @Override
    public void draw(Graphics2D g2) {
        System.out.println(rec.toString());
        lugaresFichas();
        for (var component : components) 
            component.draw(g2);
                
    }
    
    public void lugaresFichas(){
        var r=new java.util.Random();
        if(components.isEmpty())
            for (int i = 0; i < 7; i++) 
                components.add(new PlayerTileGraphic(r.nextInt(6),r.nextInt(6),new Point2D.Double((rec.getX()+(90*i)),
                        (int)(rec.getY()+rec.getHeight()+25))));
    }
    
}
