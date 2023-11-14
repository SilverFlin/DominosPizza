package ui.game;

import ui.Board.GameDTO;
import ui.MainMenu.PlayerDTO;

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
     * @param player El jugador que toma la ficha.
     */
    void takeFromPool(PlayerDTO player);

    /**
     * Actualiza la información del juego.
     *
     * @param game El DTO del juego actualizado.
     */
    void updateGame(GameDTO game);

}
