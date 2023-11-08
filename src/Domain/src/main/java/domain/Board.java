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
public class Board {

    LinkedList<BoardTile> tiles;

    public Board() {
    }

    public LinkedList<BoardTile> getTiles() {
        return tiles;
    }

    public void setTiles(LinkedList<BoardTile> tiles) {
        this.tiles = tiles;
    }

    public void putTile(DominoTile tile) {
        this.tiles.add((BoardTile) tile);
    }

    public boolean validateMove(DominoTile tile) {
        return false;
    }
}
