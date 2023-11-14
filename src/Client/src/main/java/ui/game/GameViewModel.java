package ui.game;

import java.util.List;
import ui.MainMenu.PlayerDTO;

/**
 * Interfaz que define el modelo de vista del juego.
 */
public interface GameViewModel {

    /**
     * Obtiene el tablero del juego.
     *
     * @return El DTO del tablero del juego.
     */
    BoardDTO getBoard();

    /**
     * Obtiene la información del jugador actual.
     *
     * @return El DTO del jugador actual.
     */
    PlayerDTO getMyPlayer();

    /**
     * Obtiene la cantidad de fichas restantes en la reserva.
     *
     * @return La cantidad de fichas restantes en la reserva.
     */
    int getRemainingTilesInPool();

    /**
     * Obtiene la lista de jugadores en la sala.
     *
     * @return La lista de DTO de jugadores en la sala.
     */
    List<PlayerDTO> getRoom();

}
