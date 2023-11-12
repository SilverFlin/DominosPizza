package domain;

import java.io.Serializable;

/**
 *
 */
public class Config implements Serializable {

    int tilesPerPlayer;

    public Config() {
    }

    public int getTilesPerPlayer() {
        return tilesPerPlayer;
    }

    public void setTilesPerPlayer(int tilesPerPlayer) {
        this.tilesPerPlayer = tilesPerPlayer;
    }

}
