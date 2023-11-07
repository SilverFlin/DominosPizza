/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class PoolTile extends DominoTile{

    public PoolTile(int leftValue, int rightValue) {
        super(leftValue, rightValue);
    }

  

    @Override
    public int getLeftValue() {
        return leftValue;
    }

    @Override
    public void setLeftValue(int leftValue) {
        this.leftValue = leftValue;
    }

    @Override
    public int getRightValue() {
        return rightValue;
    }

    @Override
    public void setRightValue(int rightValue) {
        this.rightValue = rightValue;
    }
    


 
}
