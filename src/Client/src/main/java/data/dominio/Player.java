/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

import java.util.List;

/**
 * Clase que representa un jugador con su avatar y sus fichas
 * @author edemb
 * @version 4/11/2023
 * @see  <a href = "https://github.com/SilverFlin/DominosPizza/blob/main/docs/diagrams/DD_client.md" /> Diagrama de Dominio </a>
 */
public class Player {

    //Lista de las fichas
    private List<PlayerTile> playerTile;
    //Obejto Avatar
    private Avatar avatar;
    //Representa al jugador dueño de sala
    private boolean isAdmin;

    /**
     * Constructor solo 
     */
    public Player() {
    }

    /**
     * Regresa una lista de las fichas
     * @return Objeto que represeta una lista de fichas
     */
    public List<PlayerTile> getTilesHand() {
        return playerTile;
    }

    /**
     * Establece una lista de fichas
     * @param tilesHand Lista de fichas
     */
    public void setTilesHand(List<PlayerTile> tilesHand) {
        this.playerTile = tilesHand;
    }

    /**
     * Regresa un Avatar
     * @return Objeto que representa un avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * Establece un Avatar
     * @param avatar Objeto que representa un avatar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * Agrega una ficha
     * @param tile Objeto que representa una ficha
     */
    public void addTile(PlayerTile tile) {
        this.playerTile.add(tile);
    }

    /**
     * Remueve una ficha de la lista
     * @param tile Objeto que representa una ficha que sera removida
     */
    public void removeTile(DominoTile tile) {
        this.playerTile.remove(tile);
    }

    /**
     * Regresa el valor si el jugador es el dueño de la partida
     * @return Booleano que contesta si es o no el dueño de la partida
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * Estable que este jugador es el dueño de la partida
     * @param isAdmin Booleano que contesta si es o no el dueño de la partida
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
