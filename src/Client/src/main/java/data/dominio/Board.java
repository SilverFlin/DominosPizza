/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

import java.util.List;

/**
 * Clase que representa el tablero con sus fichas
 * @author edemb
 * @version 4/11/2023
 * @see  <a href = "https://github.com/SilverFlin/DominosPizza/blob/main/docs/diagrams/DD_client.md" /> Diagrama de Dominio </a> 
 */
public class Board {

    //Lista de fichas del Tablero
    List<DominoTile> tiles;

    /**
     * Constructor solo
     */
    public Board() {
    }


    /**
     * Regresa una lista de fichas
     * @return Lista de fichas
     */
    public List<DominoTile> getTiles() {
        return tiles;
    }

    /**
     * Establece una lista de Fichas
     * @param tiles Lista de fichas
     */
    public void setTiles(List<DominoTile> tiles) {
        this.tiles = tiles;
    }

    /**
     * Agrega una ficha
     * @param tile 
     */
    public void addTile(DominoTile tile) {
        this.tiles.add(tile);
    }
    
    /**
     * Pone una ficha en el tren de fichas.
     * @param tile Ficha de domino
     */
    public void putTile(DominoTile tile){
        this.tiles.add(tile);
    }
    
    /**
     * Valida que la ficha se puede poner en el tren de fichas, tomando en cuenta su estado actual.
     * @param tile 
     */
    public boolean validateMove(DominoTile tile){
        var ficha = this.tiles.getFirst();
        var fichaf = this.tiles.getLast();
        if(ficha.getLeftValue()!=tile.getLeftValue() || ficha.getRightValue()!=tile.getRightValue())
            if(fichaf.getLeftValue()!=tile.getLeftValue() || fichaf.getRightValue()!=tile.getRightValue())
                return false;
        return true;
    }
}
