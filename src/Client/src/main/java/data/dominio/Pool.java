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
    // ATRIBUTOS
    List<DominoTile> dominoes;

    // CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public Pool() {
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene las fichas de domino de la pila
     * @return Una lista con las fichas de la pila
     */
    public List<DominoTile> getDominoes() {
        return dominoes;
    }
    /**
     * Método que permite asignar fichas a la pila
     * @param dominoes Fichas a asignar
     */
    public void setDominoes(List<DominoTile> dominoes) {
        this.dominoes = dominoes;
    }

    // MÉTODOS
    /**
     * Método que permite añadir fichas de la pila
     * @param tile
     */
    public void addTile(DominoTile tile){
        this.dominoes.add(tile);
    }
    /**
     * Método que permite remover fichas de la pila
     */
    public void removeTile(DominoTile tile){
        this.dominoes.remove(tile);
    }
}