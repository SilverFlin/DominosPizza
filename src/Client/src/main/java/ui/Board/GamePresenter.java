package ui.Board;

import dtos.GameDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;

/**
 *
 * @author edemb
 */
public interface GamePresenter {

    void loadBoard(WaitingRoomDTO waitingRoom, PlayerDTO player);

    void updateGame(GameDTO gameDTO);
}
