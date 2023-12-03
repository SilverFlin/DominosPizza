package graphics;

import dtos.DominoDTO;
import java.awt.Point;
import java.util.List;
import ui.game.GameViewModel;

/**
 *
 */
public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static DominoGameGraphic createDominoGameGraphic(final GameViewModel gameViewModel) {

        List<DominoDTO> boardTiles = gameViewModel.getBoard();
        BoardGraphic boardGraphic = new BoardGraphic();
        for (DominoDTO boardTile : boardTiles) {
            // Quitar punto?
//            int x = (int) (boardGraphic.rec.getBounds().getCenterX() - 20);
//            int y = (int) (boardGraphic.rec.getBounds().getCenterY() - 40);

            boardGraphic.add(new BoardTileGraphic(boardTile.getLeftValue(), boardTile.getRightValue(), new Point()));
        }

        List<DominoDTO> playerTiles = gameViewModel.getMyPlayer().getTiles();
        PlayerHandGraphic playerHandGraphic = new PlayerHandGraphic();

        for (DominoDTO playerTile : playerTiles) {
            // Quitar punto?
            playerHandGraphic.add(new PlayerTileGraphic(playerTile.getLeftValue(), playerTile.getRightValue(), new Point()));
        }

        return new DominoGameGraphic(playerHandGraphic, boardGraphic);
    }

}
