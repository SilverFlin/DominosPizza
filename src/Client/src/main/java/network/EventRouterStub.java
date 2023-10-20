package network;

import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;

/**
 *
 */
public class EventRouterStub implements EventRouter {

    @Override
    public boolean isExistentGame() {
        return false;
    }

    @Override
    public void updateGame(DominoGame dominoGame) {
        System.out.println("UpdateGame");
    }

    @Override
    public void notifyPlayers(List<Player> players) {
        System.out.println("Notify players");
    }

}
