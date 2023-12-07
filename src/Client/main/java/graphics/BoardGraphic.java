package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author JIVB
 */
public class BoardGraphic extends GraphicComposite {

    Rectangle2D.Double boardRectangle;
    int currentLength = 0;

    double center = 620.0;
    double startXCoord = 620.0;
    double endXCoord = 580.0;

    public BoardGraphic() {
        this.boardRectangle = new Rectangle2D.Double();
    }

    @Override
    public void draw(Graphics2D g2) {
        boardRectangle.setFrameFromDiagonal(100, 100, rec.getWidth() - 100, rec.getHeight() - 100);
        g2.setPaint(new Color(102, 102, 102));
        g2.fillRect(0, 0, (int) rec.getWidth(), (int) rec.getHeight());
        g2.setPaint(Color.white);
        g2.fill(boardRectangle);

//        dibujaTren();
        this.updatePositions();
        for (GraphicComponent component : components) {
            component.draw(g2);
        }
    }

    @Override
    public void add(final GraphicComponent graphicComponent) {
        super.add(graphicComponent);
    }

    private void dibujaTren() {
        if (this.components.isEmpty() || this.components.size() > 1) {
            return;
        }

        Point point = new Point((int) (rec.getBounds().getCenterX() - 20), (int) rec.getBounds().getCenterY() - 40);
        BoardTileGraphic boardTileGraphic = ((BoardTileGraphic) this.components.get(0));
        boardTileGraphic.setP(point);
        this.center = boardTileGraphic.getP().getX();
        this.startXCoord = this.center;
        this.endXCoord = this.center - boardTileGraphic.rec.getWidth();
    }

    private void updatePositions() {
        if (this.components.size() < 1) {
            return;
        }

        this.calculateLength();

        int reposition = (int) ((Puntero.gamePanel.getBounds().getWidth() - this.currentLength) / 2);
//        int reposition = 0;
        this.currentLength = reposition; // add last component widht?

        for (GraphicComponent component : components) {
            BoardTileGraphic boardTileGraphic = (BoardTileGraphic) component;
            boolean isDoublet = boardTileGraphic.leftNum == boardTileGraphic.rightNum;

            int x;
            int y;
            if (isDoublet) {
                x = (int) (this.currentLength + (boardTileGraphic.rec.getBounds().getWidth() * 2));
                y = (int) Puntero.gamePanel.getBounds().getHeight() / 2 - 40;
            } else {
                x = (int) (this.currentLength + boardTileGraphic.rec.getWidth());
                y = (int) (Puntero.gamePanel.getBounds().getHeight() / 2 - 20);
            }
            this.currentLength += boardTileGraphic.rec.getWidth();
            boardTileGraphic.setP(new Point(x, y));

        }

    }

    private void calculateLength() {
        this.currentLength = 0;
        for (GraphicComponent component : components) {
            BoardTileGraphic boardTileGraphic = (BoardTileGraphic) component;
            boolean isDoublet = boardTileGraphic.leftNum == boardTileGraphic.rightNum;
            if (isDoublet) {
                this.currentLength += boardTileGraphic.rec.getBounds().getWidth() * 2;
            } else {
                this.currentLength += boardTileGraphic.rec.getBounds().getWidth();
            }

        }

        this.currentLength -= 40;
    }

}
