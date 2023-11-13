package domain;

import java.io.Serializable;

/**
 * Clase que representa una ficha de dominó específica para ser utilizada en la
 * mano de un jugador.
 *
 * Esta clase hereda de la clase DominoTile y, por lo tanto, también implementa
 * la interfaz Serializable.
 */
public class PlayerTile extends DominoTile implements Serializable {

    /**
     * Constructor de la clase PlayerTile.
     *
     * @param leftValue Valor izquierdo de la ficha de dominó en la mano del
     * jugador.
     * @param rightValue Valor derecho de la ficha de dominó en la mano del
     * jugador.
     */
    public PlayerTile(final int leftValue, final int rightValue) {
        super(leftValue, rightValue);
    }

}
