package interfaces;

import exceptions.MissingGamePresenterException;
import exceptions.MissingMainMenuPresenterException;
import ui.Board.GameDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 * Interfaz para la Fachada del Sistema de Juego, que actúa como puente entre el sistema de juego
 * y los presentadores de la interfaz de usuario (UI).
 */
public interface GameSystemFacade {

    /**
     * Navega al panel de avatares en el menú principal.
     *
     * @throws MissingMainMenuPresenterException si no se ha establecido el MainMenuPresenter.
     */
    void goToAvatarPanel() throws MissingMainMenuPresenterException;

    /**
     * Actualiza la sala de espera con los datos proporcionados.
     *
     * @param waitingRoomDTO Los datos para actualizar la sala de espera.
     * @throws MissingMainMenuPresenterException si no se ha establecido el MainMenuPresenter.
     */
    void updateWaitingRoom(WaitingRoomDTO waitingRoomDTO) throws MissingMainMenuPresenterException;

    /**
     * Actualiza el juego con los datos proporcionados.
     *
     * @param game Los datos para actualizar el juego.
     * @throws MissingGamePresenterException si no se ha establecido el GamePresenter.
     */
    void updateGame(GameDTO game) throws MissingGamePresenterException;

    /**
     * Muestra un error para un nombre no válido en el menú principal.
     *
     * @throws MissingMainMenuPresenterException si no se ha establecido el MainMenuPresenter.
     */
    void showInvalidNameError() throws MissingMainMenuPresenterException;

}
