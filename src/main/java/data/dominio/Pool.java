
package data.dominio;



import java.util.List;
import java.util.Random;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class Pool {
    public static int remains=28; 
    public List<DominoTile> domino;

    public Pool(List<DominoTile> domino) {
        this.domino = domino;
    }

    public List<DominoTile> getDomino() {
        return domino;
    }

    public void setDomino(List<DominoTile> domino) {
        this.domino = domino;
    }

    public static int getRemains() {
        return remains;
    }

    public static void setRemains(int remains) {
        Pool.remains = remains;
    }
    /**
     * Toma una ficha del pozo.
     * @return 
     */
    public PoolTile takeTile(){
        
         Random rand = new Random();
         
        PoolTile pooltile=new PoolTile(rand.nextInt(1, 7),rand.nextInt(1, 7));
       remains--;
        return pooltile;
        
    }
    /**
     * Checa si aún hay fichas restantes.
     * @return 
     */
    public boolean validateRemainingTiles(){
        
        return remains>0;
        
    }
}
