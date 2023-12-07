package dtos;

/**
 *
 */
public class DominoDTO {

    private final int leftValue;
    private final int rightValue;

    public DominoDTO(final int leftValue, final int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public int getLeftValue() {
        return leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    @Override
    public String toString() {
        return "DominoDTO{" + "leftValue=" + leftValue + ", rightValue=" + rightValue + '}';
    }

}
