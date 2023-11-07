/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

import java.util.List;

/**
 *
 * @author edemb
 */
public class Player {
List<DominoTile> tilesHand;
Avatar avatar;
   

    public Player() {
    }

    public List<DominoTile> getTilesHand() {
        return tilesHand;
    }

    public void setTilesHand(List<DominoTile> tilesHand) {
        this.tilesHand = tilesHand;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public void addTile(DominoTile tile) {
        this.tilesHand.add(tile);
    }

    public void removeTile(DominoTile tile) {
        this.tilesHand.remove(tile);
    }

}
