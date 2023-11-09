package interfaces;

import ui.Board.GameDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 *
 */
public interface GameSystemFacade {

    void goToAvatarPanel();

    void goToWaitingRoom(WaitingRoomDTO waitingRoomDTO);

    void updateWaitingRoom(WaitingRoomDTO waitingRoomDTO);

    void updateGame(GameDTO game);

    void showInvalidNameError();
}
