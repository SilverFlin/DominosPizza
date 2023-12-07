package graphics;

import dtos.AvatarDTO;
import dtos.DominoDTO;
import dtos.PlayerDTO;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import ui.game.GameModel;
import ui.game.GameViewModel;

/**
 *
 */
public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static DominoGameGraphic createDominoGameGraphic(final GameViewModel gameViewModel) {
        ScoreBoard scoreBoard = new ScoreBoard();
        /*
        SortedMap<PlayerDTO, Integer> gameResume = new TreeMap<>();

        // Llenamos el mapa con datos de ejemplo
        PlayerDTO pdto = new PlayerDTO();
        pdto.setName("Emir");
        PlayerDTO pdto2 = new PlayerDTO();
        pdto2.setName("Luis");
        PlayerDTO pdto3 = new PlayerDTO();
        pdto3.setName("Ramon");
        gameResume.put(pdto, 10);
        gameResume.put(pdto2, 20);
        gameResume.put(pdto3, 25);
         */
        // Convertimos las entradas del mapa a una lista

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

        if (((GameModel) gameViewModel).isGameOver()) {
            List<Map.Entry<AvatarDTO, Integer>> entryList = new ArrayList<>(gameViewModel.getGameResume().entrySet());

            var resume = gameViewModel.getGameResume();

            // Ordenamos la lista por puntuación de menor a mayor
            entryList.sort(Comparator.comparing(Map.Entry::getValue));

            // Iteramos sobre la lista ordenada
            for (Map.Entry<AvatarDTO, Integer> entry : entryList) {

                Integer score = entry.getValue();
                scoreBoard.add(new PlayerScoreTextComponent(entry.getKey().getNombre(), score));
                // Realiza las operaciones necesarias con cada jugador y puntuación
                System.out.println("Jugador: " + entry.getKey().getNombre() + ", Puntuación: " + score);

            }
            dgg.add(scoreBoard);
        }
        return dgg;
    }

}