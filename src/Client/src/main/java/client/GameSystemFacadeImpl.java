package client;

import exceptions.MissingGamePresenterException;
import exceptions.MissingMainMenuPresenterException;
import interfaces.GameSystemFacade;
import dtos.GameDTO;
import ui.Board.GamePresenter;
import ui.MainMenu.MainMenuPresenter;
import dtos.WaitingRoomDTO;

/**
 * Implementación de la interfaz {@link GameSystemFacade}. Actúa como una
 * fachada para el sistema de juego, proporcionando una interfaz simplificada
 * para interactuar con los presentadores de la interfaz de usuario (UI).
 */
public class GameSystemFacadeImpl implements GameSystemFacade {

    private GamePresenter gamePresenter;
    private MainMenuPresenter mainMenuPresenter;

    /**
     * Constructor por defecto para GameSystemFacadeImpl. No es necesario
     * realizar ninguna inicialización.
     */
    public GameSystemFacadeImpl() {
        // No hace falta hacer nada.
    }

    /**
     * Establece el GamePresenter para esta fachada.
     *
     * @param gamePresenter El GamePresenter que se va a establecer.
     */
    public void setGamePresenter(final GamePresenter gamePresenter) {
        this.gamePresenter = gamePresenter;
    }

    /**
     * Establece el MainMenuPresenter para esta fachada.
     *
     * @param mainMenuPresenter El MainMenuPresenter que se va a establecer.
     */
    public void setMainMenuPresenter(final MainMenuPresenter mainMenuPresenter) {
        this.mainMenuPresenter = mainMenuPresenter;
    }

    /**
     * {@inheritDoc}
     *
     * @throws MissingMainMenuPresenterException si el MainMenuPresenter no está
     * establecido.
     */
    @Override
    public void goToAvatarPanel() throws MissingMainMenuPresenterException {
        if (mainMenuPresenter == null) {
            throw new MissingMainMenuPresenterException();
        }

        this.mainMenuPresenter.goToAvatarPanel();
    }

    /**
     * {@inheritDoc}
     *
     * @throws MissingMainMenuPresenterException si el MainMenuPresenter no está
     * establecido.
     */
    @Override
    public void updateWaitingRoom(final WaitingRoomDTO waitingRoomDTO) throws MissingMainMenuPresenterException {
        if (this.mainMenuPresenter == null) {
            throw new MissingMainMenuPresenterException();
        }

        this.mainMenuPresenter.updateWaitingRoom(waitingRoomDTO);
    }

    /**
     * {@inheritDoc}
     *
     * @throws MissingGamePresenterException si el GamePresenter no está
     * establecido.
     */
    @Override
    public void updateGame(final GameDTO game) throws MissingGamePresenterException {
        if (this.gamePresenter == null) {
            throw new MissingGamePresenterException();
        }

        this.gamePresenter.updateGame(game);
    }

    /**
     * {@inheritDoc}
     *
     * @throws MissingMainMenuPresenterException si el MainMenuPresenter no está
     * establecido.
     */
    @Override
    public void showInvalidNameError() throws MissingMainMenuPresenterException {
        if (mainMenuPresenter == null) {
            throw new MissingMainMenuPresenterException();
        }

        this.mainMenuPresenter.showInvalidNameError();
    }

}
