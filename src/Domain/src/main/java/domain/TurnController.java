package domain;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author edemb
 */
public class TurnController implements Serializable {

    public TurnController() {
    }

    public void changeTurn(LinkedList<Player> players) {
        Player player = players.pop();
        players.addLast(player);
    }
}
