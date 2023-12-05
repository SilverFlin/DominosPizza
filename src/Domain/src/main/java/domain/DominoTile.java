package domain;

import java.io.Serializable;

/**
 * Clase que representa una ficha de dominó.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos DominoTile.
 */
public class DominoTile implements Serializable {

    private int leftValue; // Valor izquierdo de la ficha
    private int rightValue; // Valor derecho de la ficha

    /**
     * Constructor de la clase DominoTile.
     *
     * @param leftValue Valor izquierdo de la ficha de dominó.
     * @param rightValue Valor derecho de la ficha de dominó.
     */
    public DominoTile(final int leftValue, final int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    /**
     * Obtiene el valor izquierdo de la ficha de dominó.
     *
     * @return Valor izquierdo de la ficha de dominó.
     */
    public int getLeftValue() {
        return leftValue;
    }

    /**
     * Establece el valor izquierdo de la ficha de dominó.
     *
     * @param leftValue Nuevo valor izquierdo de la ficha de dominó.
     */
    public void setLeftValue(final int leftValue) {
        this.leftValue = leftValue;
    }

    /**
     * Obtiene el valor derecho de la ficha de dominó.
     *
     * @return Valor derecho de la ficha de dominó.
     */
    public int getRightValue() {
        return rightValue;
    }

    /**
     * Establece el valor derecho de la ficha de dominó.
     *
     * @param rightValue Nuevo valor derecho de la ficha de dominó.
     */
    public void setRightValue(final int rightValue) {
        this.rightValue = rightValue;
    }

    public void swapValues() {
        int tempLeftValue = this.leftValue;
        this.leftValue = this.rightValue;
        this.rightValue = tempLeftValue;
    }

    @Override
    public String toString() {
        return "DominoTile{" + "leftValue=" + leftValue + ", rightValue=" + rightValue + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.leftValue;
        hash = 89 * hash + this.rightValue;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DominoTile other = (DominoTile) obj;

        if (other.getLeftValue() == this.getLeftValue() && other.getRightValue() == this.getRightValue()) {
            return true;
        }

        return other.getLeftValue() == this.getRightValue() && other.getRightValue() == this.getLeftValue();
    }

}
