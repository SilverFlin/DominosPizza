package ui.Board;

import ui.MainMenu.PlayerDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 *
 * @author edemb
 */
public interface GamePresenter {

    void loadBoard(WaitingRoomDTO waitingRoom, PlayerDTO player);

    void updateGame(GameDTO gameDTO);
}
