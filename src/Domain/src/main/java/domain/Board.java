package domain;

import exceptions.InvalidMoveException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa un tablero de juego.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos Board.
 */
public class Board implements Serializable {

    public enum Position {
        LEFT,
        RIGHT,
        INVALID
    }

    private Deque<BoardTile> tiles; // Lista de fichas en el tablero

    /**
     * Constructor de la clase Board.
     *
     * No realiza ninguna acción especial en la inicialización del tablero.
     */
    public Board() {
        this.tiles = new LinkedList<>();
    }

    /**
     * Obtiene la lista de fichas en el tablero.
     *
     * @return Lista de fichas en el tablero.
     */
    public Deque<BoardTile> getTiles() {
        return tiles;
    }

    /**
     * Establece la lista de fichas en el tablero.
     *
     * @param tiles Nueva lista de fichas en el tablero.
     */
    public void setTiles(final Deque<BoardTile> tiles) {
        this.tiles = tiles;
    }

    /**
     * Coloca una ficha en el tablero.
     *
     * @param tile Ficha de dominó a colocar en el tablero.
     * @throws exceptions.InvalidMoveException
     */
    public void putTile(final DominoTile tile) throws InvalidMoveException {
        BoardTile boardTile = new BoardTile(tile.getLeftValue(), tile.getRightValue());
        if (this.tiles.isEmpty()) {
            this.tiles.add(boardTile);
            return;
        }
        Position position = this.validateMove(boardTile);

        if (position.equals(Position.LEFT)) {
            this.tiles.addFirst(boardTile);
        } else if (position.equals(Position.RIGHT)) {
            this.tiles.addLast(boardTile);
        } else if (position.equals(Position.INVALID)) {
            throw new InvalidMoveException();
        }

    }

    /**
     * Valida un movimiento de ficha en el tablero.
     *
     * @param playerTile Ficha de dominó a validar en el tablero.
     * @return Verdadero si el movimiento es válido, falso de lo contrario.
     */
    public Position validateMove(final DominoTile playerTile) {

        // validate on left
        // validate on right
        BoardTile leftBoardTile = this.tiles.getFirst();

        if (playerTile.getRightValue() == leftBoardTile.getLeftValue()) {
            return Position.LEFT;
        } else if (playerTile.getLeftValue() == leftBoardTile.getLeftValue()) {
            playerTile.swapValues();
            return Position.LEFT;
        }

        BoardTile rightTile = this.tiles.getLast();

        if (playerTile.getLeftValue() == rightTile.getRightValue()) {
            return Position.RIGHT;
        } else if (playerTile.getRightValue() == rightTile.getRightValue()) {
            playerTile.swapValues();
            return Position.RIGHT;
        }

        return Position.INVALID;
    }
}
