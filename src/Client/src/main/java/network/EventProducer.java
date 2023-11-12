package network;

import ui.Board.GameDTO;
import ui.MainMenu.PlayerDTO;

/**
 * Interfaz que define un productor de eventos relacionados con el juego.
 */
public interface EventProducer {

    /**
     * Agrega un jugador a la sala de espera.
     *
     * @param player El jugador que se va a unir a la sala de espera.
     */
    void joinToWaitingRoom(PlayerDTO player);

    /**
     * Actualiza el estado del juego.
     *
     * @param game El estado actualizado del juego.
     */
    void updateGame(GameDTO game);

}
