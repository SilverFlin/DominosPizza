/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

/**
 *
 * @author edemb
 */
public class DominoTile {
    // ATRIBUTOS
    int leftValue;
    int rightValue;

    // CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public DominoTile() {
    }

    // MÉTODOS
    /**
     * Método que dibuja un ficha de domino
     * @throws Exception
     */
    public void paint() throws Exception {
        throw new Exception("No sirve wey!!!!!!");
    }
    /**
     * 
     * @throws Exception
     */
    public void removePaint() throws Exception {
        throw new Exception("No sirve wey!!!!!!");
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene el valor izquierdo de la ficha
     * @return El valor del lado izquierdo de la ficha
     */
    public int getLeftValue() {
        return leftValue;
    }
    /**
     * Método que permite asignar el valor izquierdo de la ficha
     * @param leftValue El valor a asignar
     */
    public void setLeftValue(int leftValue) {
        this.leftValue = leftValue;
    }
    /**
     * Método que obtiene el valor derecho de la ficha
     * @return El valor del lado derecho de la ficha
     */
    public int getRightValue() {
        return rightValue;
    }
    /**
     * Método que permite asignar el valor derecho de la ficha
     * @param rightValue El valor a asignar
     */
    public void setRightValue(int rightValue) {
        this.rightValue = rightValue;
    }
}