package interfaces;

import domain.DominoGame;
import exceptions.MissingGamePresenterException;
import exceptions.MissingMainMenuPresenterException;
import dtos.GameDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
import ui.MainMenu.MainMenuPresenter;
import ui.game.GamePresenter;

/**
 * Interfaz para la Fachada del Sistema de Juego, que actúa como puente entre el
 * sistema de juego y los presentadores de la interfaz de usuario (UI).
 */
public interface GameSystemFacade {

    /**
     * Navega al panel de avatares en el menú principal.
     *
     * @throws MissingMainMenuPresenterException si no se ha establecido el
     * MainMenuPresenter.
     */
    void goToAvatarPanel() throws MissingMainMenuPresenterException;

    /**
     * Actualiza la sala de espera con los datos proporcionados.
     *
     * @param waitingRoomDTO Los datos para actualizar la sala de espera.
     * @throws MissingMainMenuPresenterException si no se ha establecido el
     * MainMenuPresenter.
     */
    void updateWaitingRoom(WaitingRoomDTO waitingRoomDTO) throws MissingMainMenuPresenterException;

    /**
     * Actualiza el juego con los datos proporcionados.
     *
     * @param dominoGame
     * @throws MissingGamePresenterException si no se ha establecido el
     * GamePresenter.
     */
    void updateGame(DominoGame dominoGame) throws MissingGamePresenterException;

    /**
     * Muestra un error para un nombre no válido en el menú principal.
     *
     * @throws MissingMainMenuPresenterException si no se ha establecido el
     * MainMenuPresenter.
     */
    void showInvalidNameError() throws MissingMainMenuPresenterException;

    /**
     * Establece el GamePresenter para esta fachada.
     *
     * @param gamePresenter El GamePresenter que se va a establecer.
     */
    void setGamePresenter(final GamePresenter gamePresenter);

    /**
     * Establece el MainMenuPresenter para esta fachada.
     *
     * @param mainMenuPresenter El MainMenuPresenter que se va a establecer.
     */
    void setMainMenuPresenter(final MainMenuPresenter mainMenuPresenter);

    /**
     * Remueve un jugador de la interfaz gráfica.
     *
     * @param payload El jugador a ser removido.
     * @throws MissingMainMenuPresenterException si no se ha establecido el
     * MainMenuPresenter.
     */
    public void removePlayer(PlayerDTO payload);

    /**
     * Pone al jugador en estado de Ready
     *
     * @param player Jugador a establecer en Ready
     */
    void setPlayerReady(final PlayerDTO player);
    
    void startGame(final DominoGame dominoGame);
}
