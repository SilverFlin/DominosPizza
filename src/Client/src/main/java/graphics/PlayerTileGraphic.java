
package graphics;

import java.awt.Graphics2D;

/**
 *
 * @author JIVB
 */
public class PlayerTileGraphic implements GraphicComponent {
    
    Tile tile;    

    public PlayerTileGraphic() {
    }
    
    public PlayerTileGraphic(Tile tile) {
        this.tile = tile;
        
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(tile.getImagen(), null,
                    (int) tile.rec.getX(),
                    (int) tile.rec.getY());
    }
    
}
