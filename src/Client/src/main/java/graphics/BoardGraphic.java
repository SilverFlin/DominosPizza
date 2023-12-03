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

    Rectangle2D.Double tablero;

    double centro = 0;
    double i;
    double d;

    public BoardGraphic() {
        tablero = new Rectangle2D.Double();
    }

    @Override
    public void draw(Graphics2D g2) {
        tablero.setFrameFromDiagonal(100, 100, rec.getWidth() - 100, rec.getHeight() - 100);
        g2.setPaint(new Color(102, 102, 102));
        g2.fillRect(0, 0, (int) rec.getWidth(), (int) rec.getHeight());
        g2.setPaint(Color.white);
        g2.fill(tablero);

        dibujaTren();
        for (GraphicComponent component : components) {
            component.draw(g2);
        }
    }

    private void dibujaTren() {
        if (this.components.size() == 1) {
            Point point = new Point((int) (rec.getBounds().getCenterX() - 20), (int) rec.getBounds().getCenterY() - 40);
            ((BoardTileGraphic) this.components.get(0)).setP(point);
        }

//        var r = 0;
////        var r = ((BoardTileGraphic) this.components.get(0)).getLeftNum();
//        var t = new BoardTileGraphic(r, r, new Point((int) (rec.getBounds().getCenterX() - 20), (int) rec.getBounds().getCenterY() - 40));
//        centro = t.getP().getX();
//        i = centro;
//        d = centro - t.rec.getWidth();
//        components.add(t);
    }
//        BoardTileGraphic boardTileGraphic = (BoardTileGraphic) this.components.get(0);
//        if (boardTileGraphic.getLeftNum() != boardTileGraphic.getRightNum()) {
//            throw new IllegalStateException("Ficha no es mula");
//        }
//
//        boardTileGraphic.setP(new Point((int) (rec.getBounds().getCenterX() - 20), (int) rec.getBounds().getCenterY() - 40));
//
//        centro = boardTileGraphic.getP().getX();
//        i = centro;
//        d = centro - boardTileGraphic.rec.getWidth();
//        components.add(boardTileGraphic);
//    }

}
