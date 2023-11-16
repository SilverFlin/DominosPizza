package graphics;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIVB
 */
public class DominoGameGraphic extends GraphicComposite {
    
    PlayersGraphic pg;
    MyPlayerGraphic mp;
    PlayerHandGraphic ph;
    BoardGraphic bg;
    List <GraphicComposite> graficos;

    public DominoGameGraphic() {
        graficos = new ArrayList<>();
        bg=new BoardGraphic();
        pg=new PlayersGraphic();
        mp=new MyPlayerGraphic();
        ph=new PlayerHandGraphic();
        graficos.add(bg);
        graficos.add(pg);
        graficos.add(mp);
        graficos.add(ph);
    }

    public DominoGameGraphic(PlayersGraphic pg, MyPlayerGraphic mp, PlayerHandGraphic ph, BoardGraphic bg) {
        this.pg = pg;
        this.mp = mp;
        this.ph = ph;
        this.bg = bg;
        graficos = new ArrayList<>();
        graficos.add(bg);
        graficos.add(pg);
        graficos.add(mp);
        graficos.add(ph);
        
    }

    @Override
    public void draw(Graphics2D g2) {
        for (var g : graficos) 
            g.draw(g2);
        
    }
    
    
    
    
}
