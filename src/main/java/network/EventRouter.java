package network;

import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;

/**
 *
 */
public interface EventRouter {

    boolean isExistentGame();

    void updateGame(DominoGame dominoGame);
    
    void notifyPlayers(List<Player> players);
}
