package ui.game;

import domain.DominoGame;
import domain.Player;
import dtos.DominoDTO;
import dtos.GameDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;

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
     * @param dominoGame
     * @param game El DTO del juego actualizado.
     */
    void updateGame(DominoGame dominoGame);

    /**
     * Carga el tablero con la sala de espera y la información del jugador
     * actual.
     *
     * @param dominoGame
     * @param waitingRoom La sala de espera.
     * @param myPlayer El jugador actual.
     */
    void loadBoard(DominoGame dominoGame, Player myPlayer);

    /**
     * Toma una ficha de la reserva para el jugador.
     *
     * @param player El jugador que toma la ficha.
     */
    void takeFromPool();

    void skipTurn();

    public void removePlayer(PlayerDTO player);

    public void gameOver(DominoGame dominoGame);
}
