package domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class Player implements Serializable{

    List<PlayerTile> tilesInHand;
    Avatar avatar;
    boolean isAdmin;
    boolean isReady;

    public Player() {
        isReady = false;
    }

    public List<PlayerTile> getTilesInHand() {
        return tilesInHand;
    }

    public void setTilesInHand(List<PlayerTile> tilesInHand) {
        this.tilesInHand = tilesInHand;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void addTile(DominoTile tile) {
        this.tilesInHand.add((PlayerTile) tile);

    }

    public void removeTile(PlayerTile tile) {
        this.tilesInHand.remove(tile);
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady() {
        this.isReady = true;
    }
}
