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
public class Board {
    // ATRIBUTOS
    List<DominoTile> tiles;

    // CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public Board() {
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene las fichas de domino en una lista
     * @return Una lista de las fichas
     */
    public List<DominoTile> getTiles() {
        return tiles;
    }
    /**
     * Método que asigna fichas a una lista de fichas
     * @param tiles Fichas a asignar
     */
    public void setTiles(List<DominoTile> tiles) {
        this.tiles = tiles;
    }

    // MÉTODOS
    /**
     * Método que agrega una ficha de domino
     * @param tile Ficha a añadir
     */
    public void addTile(DominoTile tile) {
        this.tiles.add(tile);
    }
}