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
    // ATRIBUTOS
    List<DominoTile> tilesHand;
    Avatar avatar;

    // CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public Player() {
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene las fichas a la mano del jugador
     * @return Las fichas a la mano del jugador
     */
    public List<DominoTile> getTilesHand() {
        return tilesHand;
    }
    /**
     * Método que permite asignar fichas a la mano del jugador
     * @param tilesHand Fichas a asignar
     */
    public void setTilesHand(List<DominoTile> tilesHand) {
        this.tilesHand = tilesHand;
    }
    /**
     * Método que obtiene el avatar del jugador
     * @return El avatar del jugador
     */
    public Avatar getAvatar() {
        return avatar;
    }
    /**
     * Método que permite asignar un avatar al jugador
     * @param avatar Avatar a asignar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    // MÉTODOS
    /**
     * Método que permite añadir una ficha de la mano del jugador
     * @param tile Ficha a añadir
     */
    public void addTile(DominoTile tile) {
        this.tilesHand.add(tile);
    }
    /**
     * Método que permite eliminar una ficha de la mano del jugador
     * @param tile Ficha a eliminar
     */
    public void removeTile(DominoTile tile) {
        this.tilesHand.remove(tile);
    }
}