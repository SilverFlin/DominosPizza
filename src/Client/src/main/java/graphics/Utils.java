package graphics;

import dtos.DominoDTO;
import dtos.OpponentDTO;
import dtos.PlayerDTO;
import java.awt.Point;
import java.awt.image.BufferedImage;
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

        PlayerDTO myPlayer = gameViewModel.getMyPlayer();
        MyPlayerGraphic myPlyerGraphic = new MyPlayerGraphic();

        AvatarGraphic myAvatarGraphic = new AvatarGraphic(myPlayer.getAvatar().getNombre(), new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
        myPlyerGraphic.add(myAvatarGraphic);

        PlayersGraphic oppnents = new PlayersGraphic();

        for (OpponentDTO o : gameViewModel.getRoom()) {
            oppnents.add(new AvatarGraphic(o.getAvatar().getNombre(), new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)));
        }

        List<DominoDTO> boardTiles = gameViewModel.getBoard();
        BoardGraphic boardGraphic = new BoardGraphic();
        for (DominoDTO boardTile : boardTiles) {
            boardGraphic.add(new BoardTileGraphic(boardTile.getLeftValue(), boardTile.getRightValue(), new Point()));
        }

        List<DominoDTO> playerTiles = gameViewModel.getMyPlayer().getTiles();
        PlayerHandGraphic playerHandGraphic = new PlayerHandGraphic();

        for (DominoDTO playerTile : playerTiles) {
            playerHandGraphic.add(new PlayerTileGraphic(playerTile.getLeftValue(), playerTile.getRightValue(), new Point()));
        }

        return new DominoGameGraphic(playerHandGraphic, boardGraphic);
    }

}
