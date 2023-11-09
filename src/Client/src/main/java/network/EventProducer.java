package network;

import ui.Board.GameDTO;
import ui.MainMenu.PlayerDTO;

/**
 *
 */
public interface EventProducer {

    void joinToWaitingRoom(PlayerDTO player);

    void updateGame(GameDTO game);

}
