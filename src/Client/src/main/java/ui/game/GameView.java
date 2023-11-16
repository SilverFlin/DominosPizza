package ui.game;

/**
 * Interfaz que define la vista del juego.
 */
public interface GameView {

    /**
     * Muestra un error de movimiento no válido.
     */
    void showInvalidMoveError();

    /**
     * Actualiza la vista del juego con el modelo proporcionado.
     *
     * @param gameViewModel El modelo del juego.
     */
    void updateGame(GameViewModel gameViewModel);

    void open();

    void close();

}
