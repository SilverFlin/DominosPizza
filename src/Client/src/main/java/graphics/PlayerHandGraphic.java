
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
    
    public PlayerHandGraphic(java.awt.Rectangle rec){
        this.rec=rec;
        lugaresFichas();
    }

    @Override
    public void draw(Graphics2D g2) {
        lugaresFichas();
        if(selecionada!=null){
            g2.setPaint(java.awt.Color.green);
            var s=selecionada;
            s.setP(s.rec.getLocation());
            s.rec.setFrameFromDiagonal(s.p.getX()-5, s.p.getY()-5, s.p.getX()+s.rec.getWidth()+5, s.p.getY()+s.rec.getHeight()+5);
            g2.fill(s.rec);
        }
        for (var component : components) 
            component.draw(g2);
    }
    
    public void lugaresFichas(){
        var r=new java.util.Random();
        this.rec.setFrameFromDiagonal(100, 100, rec.getWidth()-100, rec.getHeight()-100);
        if(components.isEmpty())
            for (int i = 0; i < 7; i++) 
                components.add(new PlayerTileGraphic(r.nextInt(6),r.nextInt(6),new Point2D.Double(rec.getX()+(90*i),rec.getY()+rec.getHeight()+10)));
        else{
            var newComponents=new java.util.ArrayList<GraphicComponent>();
            for (int i = 0; i < components.size(); i++){
                var p = (PlayerTileGraphic) components.get(i);
                p.setP(new Point2D.Double(rec.getX()+(90*i),rec.getY()+rec.getHeight()+10));
                newComponents.add(p);
            }
            components=newComponents;
        }
    }

    public PlayerTileGraphic getSelecionada() {
        return selecionada;
    }

    public void setSelecionada(PlayerTileGraphic selecionada) {
        this.selecionada = selecionada;
    }
}
