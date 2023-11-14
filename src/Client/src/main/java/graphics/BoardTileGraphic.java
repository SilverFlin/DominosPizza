package graphics;


/**
 *
 * @author JIVB
 */
public class BoardTileGraphic implements GraphicComponent
{

    int left;
    int rigth;

    public BoardTileGraphic(int left, int rigth) {
        this.left = left;
        this.rigth = rigth;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRigth() {
        return rigth;
    }

    public void setRigth(int rigth) {
        this.rigth = rigth;
    }

    @Override
    public void draw() {

    }

}
