package ui.game;

import dtos.DominoDTO;
import dtos.OpponentDTO;
import java.util.List;
import dtos.PlayerDTO;
import java.util.SortedMap;

/**
 * Interfaz que define el modelo de vista del juego.
 */
public interface GameViewModel {

    /**
     * Obtiene el tren de fichas del juego.
     *
     * @return Lista del tren de fichas.
     */
    List<DominoDTO> getBoard();

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
    List<OpponentDTO> getRoom();

    PlayerDTO getActivePlayer();

    SortedMap<PlayerDTO, Integer> getGameResume();

}
