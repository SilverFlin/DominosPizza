package domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class Board implements Serializable {

    List<BoardTile> tiles;

    public Board() {
    }

    public List<BoardTile> getTiles() {
        return tiles;
    }

    public void setTiles(List<BoardTile> tiles) {
        this.tiles = tiles;
    }

    public void putTile(DominoTile tile) {
        this.tiles.add((BoardTile) tile);
    }

    public boolean validateMove(DominoTile tile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
