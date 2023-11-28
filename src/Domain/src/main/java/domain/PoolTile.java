package domain;

import java.io.Serializable;

/**
 * Clase que representa una ficha de dominó específica para ser utilizada en la
 * piscina del juego.
 *
 * Esta clase hereda de la clase DominoTile y, por lo tanto, también implementa
 * la interfaz Serializable.
 */
public class PoolTile extends DominoTile implements Serializable {

    /**
     * Constructor de la clase PoolTile.
     *
     * @param leftValue Valor izquierdo de la ficha de dominó en la piscina.
     * @param rightValue Valor derecho de la ficha de dominó en la piscina.
     */
    public PoolTile(int leftValue, int rightValue) {
        super(leftValue, rightValue);
    }

}
