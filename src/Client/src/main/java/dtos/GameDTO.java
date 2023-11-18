package dtos;

import java.util.List;

/**
 *
 */
public class GameDTO {

    private final List<DominoDTO> pool;
    private final List<PlayerDTO> players;
    private final List<DominoDTO> board;
    private final int initialTiles;

    public GameDTO(final List<DominoDTO> poolTiles, final List<PlayerDTO> players, final List<DominoDTO> board, final int initialTiles) {
        this.pool = poolTiles;
        this.players = players;
        this.board = board;
        this.initialTiles = initialTiles;
    }

    public List<DominoDTO> getPoolTiles() {
        return pool;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public List<DominoDTO> getBoard() {
        return board;
    }

    public List<DominoDTO> getPool() {
        return pool;
    }

    public int getInitialTiles() {
        return initialTiles;
    }

}
