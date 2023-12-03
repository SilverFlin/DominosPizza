package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un tablero de juego.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos Board.
 */
public class Board implements Serializable {

    private List<BoardTile> tiles; // Lista de fichas en el tablero

    /**
     * Constructor de la clase Board.
     *
     * No realiza ninguna acción especial en la inicialización del tablero.
     */
    public Board() {
        this.tiles = new ArrayList<>();
    }

    /**
     * Obtiene la lista de fichas en el tablero.
     *
     * @return Lista de fichas en el tablero.
     */
    public List<BoardTile> getTiles() {
        return tiles;
    }

    /**
     * Establece la lista de fichas en el tablero.
     *
     * @param tiles Nueva lista de fichas en el tablero.
     */
    public void setTiles(final List<BoardTile> tiles) {
        this.tiles = tiles;
    }

    /**
     * Coloca una ficha en el tablero.
     *
     * @param tile Ficha de dominó a colocar en el tablero.
     */
    public void putTile(DominoTile tile) {
        this.tiles.add(new BoardTile(tile.getLeftValue(), tile.getRightValue()));
    }

    /**
     * Valida un movimiento de ficha en el tablero.
     *
     * @param tile Ficha de dominó a validar en el tablero.
     * @return Verdadero si el movimiento es válido, falso de lo contrario.
     */
    public boolean validateMove(DominoTile tile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
