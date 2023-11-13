package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el conjunto de fichas disponibles para el juego
 * (piscina).
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos Pool.
 */
public class Pool implements Serializable {

    private List<PoolTile> dominoes; // Lista de fichas en la piscina

    /**
     * Constructor de la clase Pool.
     */
    public Pool() {
        this.dominoes = new ArrayList<>();
    }

    /**
     * Obtiene la lista de fichas en la piscina.
     *
     * @return Lista de fichas en la piscina.
     */
    public List<PoolTile> getDominoes() {
        return dominoes;
    }

    /**
     * Establece la lista de fichas en la piscina.
     *
     * @param dominoes Nueva lista de fichas en la piscina.
     */
    public void setDominoes(final List<PoolTile> dominoes) {
        this.dominoes = dominoes;
    }

    /**
     * Toma una ficha de la piscina.
     *
     * @return Ficha de dominó tomada de la piscina.
     */
    public PoolTile takeTile() {
        return this.dominoes.remove(this.dominoes.size() - 1);
    }

    /**
     * Valida si quedan fichas en la piscina.
     *
     * @return Verdadero si quedan fichas, falso de lo contrario.
     */
    public boolean validateRemainingTiles() {
        return !this.dominoes.isEmpty();
    }
}
