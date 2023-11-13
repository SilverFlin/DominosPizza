package domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class DominoGame implements Serializable {

    private boolean isReady;
    private Pool pool;
    private Board board;
    private Config config;
    private List<Player> players;
    private TurnController turnController;

    private static DominoGame dominoGame;

    private DominoGame() {
    }

    public boolean isIsReady() {
        return isReady;
    }

    public void setIsReady(final boolean isReady) {
        this.isReady = isReady;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(final Pool pool) {
        this.pool = pool;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(final Board board) {
        this.board = board;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(final Config config) {
        this.config = config;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Player> players) {
        this.players = players;
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public void setTurnController(TurnController turnController) {
        this.turnController = turnController;
    }

    public void shufflePlayers() {
        Collections.shuffle(players);
    }

    public void changeTurn() {
        List<Player> sortedPlayers = this.turnController.changeTurn(players);
        this.players = sortedPlayers;

    }

    public void addPlayer(final Player player) {
        if (!players.isEmpty()) {
            for (var p : players) {
                if (p.getAvatar().getName().compareTo(player.getAvatar().getName()) == 0) {
                    return;
                }
            }
        }
        players.add(player);

    }

    public static DominoGame getInstance() {
        if (DominoGame.dominoGame == null) {
            DominoGame.dominoGame = new DominoGame();
        }
        return DominoGame.dominoGame;
    }

    public void setTileAmountConfig(final int cantTile) {
        this.config.setTilesPerPlayer(cantTile);
    }

    public boolean startGame() {

        for (Player player : this.getPlayers()) {
            if (!player.isReady()) {
                return false;
            }
        }
        return true;
    }

    public void putTileBoard(final DominoTile tile) {
        this.board.putTile(tile);
    }

    public void takeFromPool(final Player player) {
        player.addTile(this.pool.takeTile());
    }

}
