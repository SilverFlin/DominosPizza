package domain;

import java.io.Serializable;

/**
 * Clase que representa una ficha de dominó específica para ser utilizada en un
 * tablero de juego.
 *
 * Esta clase hereda de la clase DominoTile y, por lo tanto, también implementa
 * la interfaz Serializable.
 */
public class BoardTile extends DominoTile implements Serializable {

    /**
     * Constructor de la clase BoardTile.
     *
     * @param leftValue Valor izquierdo de la ficha de dominó en el tablero.
     * @param rightValue Valor derecho de la ficha de dominó en el tablero.
     */
    public BoardTile(final int leftValue, final int rightValue) {
        super(leftValue, rightValue);
    }

}
