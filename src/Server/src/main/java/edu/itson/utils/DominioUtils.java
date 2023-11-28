
package edu.itson.utils;

import domain.PoolTile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toled
 */
public class DominioUtils {

    private DominioUtils() {
    }
    
    
    public static List<PoolTile> createAllTiles(){
         List<PoolTile> tiles = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                PoolTile tile = new PoolTile(i, j);
                tiles.add(tile);
                if (i != j) {
                    PoolTile reverseTile = new PoolTile(j, i);
                    tiles.add(reverseTile);
                }
            }
        }
        return tiles;
    }
}
