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

    int leftValue;
    int rightValue;
    
public DominoTile(int leftValue, int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public void paint() throws Exception {
        throw new Exception("No sirve wey!!!!!!");

    }

    public void removePaint() throws Exception {
        throw new Exception("No sirve wey!!!!!!");

    }

    public int getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(int leftValue) {
        this.leftValue = leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    public void setRightValue(int rightValue) {
        this.rightValue = rightValue;
    }

}
