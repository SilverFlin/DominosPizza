/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

/**
 *
 * @author edemb
 */
public class Config {
    // ATRIBUTOS
    int tilesPerPlayer;

    // CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public Config() {
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene el número de fichas de domino por jugador
     * @return Número de fichas de cada jugador
     */
    public int getTilesPerPlayer() {
        return tilesPerPlayer;
    }
    /**
     * Método que asigna un número de fichas de domino por jugador
     * @param tilesPerPlayer Número de fichas a asignar
     */
    public void setTilesPerPlayer(int tilesPerPlayer) {
        this.tilesPerPlayer = tilesPerPlayer;
    }
}