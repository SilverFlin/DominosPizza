package ui.game;

import ui.Board.GameDTO;
import ui.MainMenu.PlayerDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 * Interfaz que define el presentador del juego.
 */
public interface GamePresenter {

    /**
     * Coloca una ficha en el tablero.
     *
     * @param tile La ficha a colocar.
     */
    void putTileInBoard(DominoDTO tile);

    /**
     * Actualiza la información del juego.
     *
     * @param game El DTO del juego actualizado.
     */
    void updateGame(GameDTO game);

    /**
     * Carga el tablero con la sala de espera y la información del jugador
     * actual.
     *
     * @param waitingRoom La sala de espera.
     * @param myPlayer El jugador actual.
     */
    void loadBoard(WaitingRoomDTO waitingRoom, PlayerDTO myPlayer);

    /**
     * Toma una ficha de la reserva para el jugador.
     *
     * @param player El jugador que toma la ficha.
     */
    void takeFromPool(PlayerDTO player);
}
