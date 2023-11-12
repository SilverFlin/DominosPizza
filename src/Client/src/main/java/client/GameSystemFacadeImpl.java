package client;

import exceptions.MissingGamePresenterException;
import exceptions.MissingMainMenuPresenterException;
import interfaces.GameSystemFacade;
import ui.Board.GameDTO;
import ui.Board.GamePresenter;
import ui.MainMenu.MainMenuPresenter;
import ui.MainMenu.WaitingRoomDTO;

/**
 *
 */
public class GameSystemFacadeImpl implements GameSystemFacade {

    private GamePresenter gamePresenter;
    private MainMenuPresenter mainMenuPresenter;

    public GameSystemFacadeImpl() {
        // No hace falta hacer nada.
    }

    public void setGamePresenter(final GamePresenter gamePresenter) {
        this.gamePresenter = gamePresenter;
    }

    public void setMainMenuPresenter(final MainMenuPresenter mainMenuPresenter) {
        this.mainMenuPresenter = mainMenuPresenter;
    }

    @Override
    public void goToAvatarPanel() throws MissingMainMenuPresenterException {
        if (mainMenuPresenter == null) {
            throw new MissingMainMenuPresenterException();
        }

        this.mainMenuPresenter.goToAvatarPanel();
    }

    @Override
    public void updateWaitingRoom(WaitingRoomDTO waitingRoomDTO) throws MissingMainMenuPresenterException {
        if (this.mainMenuPresenter == null) {
            throw new MissingMainMenuPresenterException();
        }

        this.mainMenuPresenter.updateWaitingRoom(waitingRoomDTO);
    }

    @Override
    public void updateGame(GameDTO game) throws MissingGamePresenterException {
        if (this.gamePresenter == null) {
            throw new MissingGamePresenterException();
        }

        this.gamePresenter.updateGame(game);
    }

    @Override
    public void showInvalidNameError() throws MissingMainMenuPresenterException {
        if (mainMenuPresenter == null) {
            throw new MissingMainMenuPresenterException();
        }

        this.mainMenuPresenter.showInvalidNameError();
    }

}
