/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.LinkedList;

/**
 *
 * @author edemb
 */
public class Player {

    LinkedList<PlayerTile> tilesInHand;
    Avatar avatar;
    boolean isAdmin;
    boolean isReady;

    public Player() {
        isReady = false;
    }

    public LinkedList<PlayerTile> getTilesInHand() {
        return tilesInHand;
    }

    public void setTilesInHand(LinkedList<PlayerTile> tilesInHand) {
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
