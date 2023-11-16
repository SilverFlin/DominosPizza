package ui.game;

import dtos.DominoDTO;
import dtos.GameDTO;

/**
 * Interfaz que define el modelo del juego.
 */
public interface GameModel {

    /**
     * Obtiene una ficha de la reserva.
     *
     * @return La ficha obtenida de la reserva.
     */
    DominoDTO getTileFromPool();

    /**
     * Coloca una ficha en el tablero.
     *
     * @param tile La ficha a colocar.
     */
    void putTileInBoard(DominoDTO tile);

    /**
     * Toma una ficha de la reserva para el jugador.
     *
     */
    void takeFromPool();

    /**
     * Actualiza la información del juego.
     *
     * @param game El DTO del juego actualizado.
     */
    void updateGame(GameDTO game);

}
