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

    List<DominoTile> tiles;

    public Board() {
    }


    public List<DominoTile> getTiles() {
        return tiles;
    }

    public void setTiles(List<DominoTile> tiles) {
        this.tiles = tiles;
    }

    public void addTile(DominoTile tile) {
        this.tiles.add(tile);
    }


}
