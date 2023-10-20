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
public class Pool {
    List<DominoTile> dominoes;

    public Pool() {
    }

    public List<DominoTile> getDominoes() {
        return dominoes;
    }

    public void setDominoes(List<DominoTile> dominoes) {
        this.dominoes = dominoes;
    }
    
    public void addTile(DominoTile tile){
        this.dominoes.add(tile);
    }
        public void removeTile(DominoTile tile){
        this.dominoes.remove(tile);
    }
}
