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
public class Pool {
    LinkedList<PoolTile> dominoes;

    public Pool() {
    }

    public LinkedList<PoolTile> getDominoes() {
        return dominoes;
    }

    public void setDominoes(LinkedList<PoolTile> dominoes) {
        this.dominoes = dominoes;
    }
    
    public PoolTile takeTile(){
    return this.dominoes.pop();
    }
    
    /**
     * 
     * @return true if has, false if no 
     */
    public boolean validateRemainingTiles(){
    
        return this.dominoes.size()!=0;
        
    }
}
