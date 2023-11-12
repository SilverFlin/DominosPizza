package domain;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author edemb
 */
public class Pool implements Serializable {

    LinkedList<PoolTile> dominoes;

    public Pool() {
    }

    public LinkedList<PoolTile> getDominoes() {
        return dominoes;
    }

    public void setDominoes(LinkedList<PoolTile> dominoes) {
        this.dominoes = dominoes;
    }

    public PoolTile takeTile() {
        return this.dominoes.pop();
    }

    /**
     *
     * @return true if has, false if no
     */
    public boolean validateRemainingTiles() {

        return this.dominoes.size() != 0;

    }
}
