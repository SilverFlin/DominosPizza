package ui.game;

import domain.DominoGame;
import domain.Player;
import dtos.DominoDTO;
import dtos.PlayerDTO;
import exceptions.IllegalBoardStateException;

/**
 * Interfaz que define el modelo del juego.
 */
public interface GameModel {

    public void setMyPlayer(final Player myPlayer);

    /**
     * Coloca una ficha en el tablero.
     *
     * @param tile La ficha a colocar.
     * @throws exceptions.IllegalBoardStateException
     */
    void putTileInBoard(DominoDTO tile) throws IllegalBoardStateException;

    /**
     * Toma una ficha de la reserva para el jugador.
     *
     */
    void takeFromPool();

    /**
     * Actualiza la información del juego.
     *
     * @param domninoGame
     */
    void updateGame(DominoGame domninoGame);

    DominoGame getDominoGame();

    boolean skipTurn(Player player);
    
    boolean isGameOver();

    public void removePlayer(PlayerDTO player);

}
