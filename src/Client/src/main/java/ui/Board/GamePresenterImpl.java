package ui.Board;

import ui.MainMenu.PlayerDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 *
 * @author edemb
 */
public class GamePresenterImpl implements GamePresenter {

    BoardJFrame board = new BoardJFrame();

    @Override
    public void loadBoard(WaitingRoomDTO waitingRoom, PlayerDTO player) {
        board.setVisible(true);
    }

    @Override
    public void updateGame(GameDTO gameDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
