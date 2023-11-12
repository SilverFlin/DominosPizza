package interfaces;

import exceptions.MissingGamePresenterException;
import exceptions.MissingMainMenuPresenterException;
import ui.Board.GameDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 *
 */
public interface GameSystemFacade {

    void goToAvatarPanel() throws MissingMainMenuPresenterException;

    void updateWaitingRoom(WaitingRoomDTO waitingRoomDTO) throws MissingMainMenuPresenterException;

    void updateGame(GameDTO game) throws MissingGamePresenterException;

    void showInvalidNameError() throws MissingMainMenuPresenterException;
;
}
