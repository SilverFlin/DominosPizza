package graphics;

import dtos.AvatarDTO;
import dtos.DominoDTO;
import dtos.OpponentDTO;
import dtos.PlayerDTO;
import java.awt.Point;
import java.awt.image.BufferedImage;
import dtos.PlayerDTO;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import ui.game.GameModel;
import ui.game.GameViewModel;

/**
 *
 */
public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static DominoGameGraphic createDominoGameGraphic(final GameViewModel gameViewModel) throws IOException {
        ScoreBoard scoreBoard = new ScoreBoard();

        PlayerDTO myPlayer = gameViewModel.getMyPlayer();
        MyPlayerGraphic myPlyerGraphic = new MyPlayerGraphic();

        AvatarGraphic myAvatarGraphic = new AvatarGraphic(myPlayer.getAvatar().getNombre() +"\n Fichas Restantes: "+myPlayer.getTiles().size(), ImageIO.read(new File(myPlayer.getAvatar().getImage())));
        myPlyerGraphic.add(myAvatarGraphic);

        PlayersGraphic oppnents = new PlayersGraphic();

        for (OpponentDTO o : gameViewModel.getRoom()) {
            oppnents.add(new AvatarGraphic(o.getAvatar().getNombre()+"\n Fichas Restantes: "+myPlayer.getTiles().size(), ImageIO.read(new File(o.getAvatar().getImage()))));
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

        DominoGameGraphic dgg = new DominoGameGraphic(playerHandGraphic, boardGraphic);
        dgg.add(myPlyerGraphic);
        dgg.add(oppnents);

        if (((GameModel) gameViewModel).isGameOver()) {
            scoreBoard.components.clear();
            
            List<Map.Entry<AvatarDTO, Integer>> entryList = new ArrayList<>(gameViewModel.getGameResume().entrySet());

            // Ordenamos la lista por puntuación de menor a mayor
            entryList.sort(Comparator.comparing(Map.Entry::getValue));

            // Iteramos sobre la lista ordenada
            for (Map.Entry<AvatarDTO, Integer> entry : entryList) {
                Integer score = entry.getValue();
                PlayerScoreTextComponent psc = new PlayerScoreTextComponent(entry.getKey().getNombre(), score);
                scoreBoard.add(psc);
                System.out.println("Jugador: " + entry.getKey().getNombre() + ", Puntuación: " + score);
            }
            dgg.add(scoreBoard);
        }
        return dgg;
    }

}
