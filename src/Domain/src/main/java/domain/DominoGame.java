package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa un juego de dominó.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos DominoGame.
 */
public class DominoGame implements Serializable {

    private boolean isReady;
    private Pool pool;
    private Board board;
    private Config config;
    private List<Player> players;
    private TurnController turnController;

    /**
     * Constructor privado de la clase DominoGame. Se utiliza el patrón
     * Singleton para garantizar una única instancia de la clase.
     */
    public DominoGame() {
        this.config = new Config();
        this.turnController = new TurnController();
        this.players = new ArrayList<>();
        this.board = new Board();
        this.pool = new Pool();
    }

    /**
     * Obtiene el estado de preparación del juego.
     *
     * @return true si el juego está listo para comenzar, false de lo contrario.
     */
    public boolean isIsReady() {
        return isReady;
    }

    /**
     * Establece el estado de preparación del juego.
     *
     * @param isReady true si el juego está listo para comenzar, false de lo
     * contrario.
     */
    public void setIsReady(final boolean isReady) {
        this.isReady = isReady;
    }

    /**
     * Obtiene la piscina de fichas del juego.
     *
     * @return Piscina de fichas del juego.
     */
    public Pool getPool() {
        return pool;
    }

    /**
     * Establece la piscina de fichas del juego.
     *
     * @param pool Nueva piscina de fichas del juego.
     */
    public void setPool(final Pool pool) {
        this.pool = pool;
    }

    /**
     * Obtiene el tablero del juego.
     *
     * @return Tablero del juego.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Establece el tablero del juego.
     *
     * @param board Nuevo tablero del juego.
     */
    public void setBoard(final Board board) {
        this.board = board;
    }

    /**
     * Obtiene la configuración del juego.
     *
     * @return Configuración del juego.
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Establece la configuración del juego.
     *
     * @param config Configuración del juego.
     */
    public void setConfig(Config config) {
        this.config = config;
    }

    /**
     * Obtiene la lista de jugadores en el juego.
     *
     * @return Lista de jugadores en el juego.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Establece la lista de jugadores en el juego.
     *
     * @param players Nueva lista de jugadores en el juego.
     */
    public void setPlayers(final List<Player> players) {
        this.players = players;
    }

    /**
     * Baraja aleatoriamente la lista de jugadores en el juego.
     */
    public void initTurns() {
        // Checa quien puede poner mula
        // Lo pone primero, shuffle a los demás

        PlayerTile highestDoublet = null;
        Player firstPlayer = null;

        for (Player player : this.players) {
            List<PlayerTile> playerTiles = player.getTilesInHand();
            System.out.println(playerTiles);
            for (PlayerTile playerTile : playerTiles) {
                boolean isDoublet = playerTile.getLeftValue() == playerTile.getRightValue();
                
                if(highestDoublet == null && isDoublet){
                    highestDoublet = playerTile;
                    firstPlayer = player;
                    continue;
                }
                
                if(highestDoublet == null){
                    continue;
                }
                
                boolean isHigher = highestDoublet.getLeftValue() < playerTile.getLeftValue();
                if (isDoublet && isHigher) {
                    highestDoublet = playerTile;
                    firstPlayer = player;
                }
            }

        }

        if (firstPlayer == null || highestDoublet == null) {
//            takeAllFromPool
            System.out.println("takeAllFromPool not implemented");
//            this.initTurns();
            return;
        }
        firstPlayer.removeTile(highestDoublet);

        this.board.putTile((DominoTile) highestDoublet);
        this.players.remove(firstPlayer);

        List<Player> mutablePlayers = new ArrayList<>(players);
        Collections.shuffle(mutablePlayers);
        players = mutablePlayers;

        this.players.add(0, firstPlayer);

    }

    public void shuffleTiles() {
        List<PoolTile> poolTiles = this.pool.getDominoes();
        Collections.shuffle(poolTiles);
        this.pool.setDominoes(poolTiles);
    }

    /**
     * Cambia el turno actual de los jugadores en el juego.
     */
    public void changeTurn() {
        List<Player> sortedPlayers = this.turnController.changeTurn(players);
        this.players = sortedPlayers;
    }

    /**
     * Obtiene al jugador activo actual.
     *
     * @return Jugador activo.
     */
    public Player getCurrentPlayer() {
        return this.players.get(0);
    }

    /**
     * Agrega un jugador al juego.
     *
     * @param player Jugador que se agregará al juego.
     */
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

    /**
     * Establece la cantidad de fichas en la configuración del juego.
     *
     * @param cantTile Cantidad de fichas por jugador.
     */
    public void setTileAmountConfig(final int cantTile) {
        this.config.setTilesPerPlayer(cantTile);
    }

    /**
     * Inicia el juego verificando si todos los jugadores están listos.
     *
     * @return true si el juego se inicia correctamente, false si algún jugador
     * no está listo.
     */
    public boolean startGame() {
        for (Player player : this.getPlayers()) {
            if (!player.isReady()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Coloca una ficha en el tablero del juego.
     *
     * @param tile Ficha de dominó que se colocará en el tablero.
     */
    public void putTileBoard(final DominoTile tile) {
        BoardTile boardTile = new BoardTile(tile.getLeftValue(), tile.getRightValue());
        this.board.putTile(boardTile);
    }

    /**
     * Toma una ficha de la piscina y la asigna a un jugador.
     *
     * @param player Jugador que tomará la ficha.
     */
    public void takeFromPool(final Player player) {
        player.addTile((DominoTile) this.pool.takeTile());
    }

    /**
     * Verifica si el juego se puede poner en listo si las condiciones se
     * cumplen
     */
    public void setGameReady() {
        if (!startGame()) {
            if (players.size() <= 4 || players.size() >= 2) {
                if (this.config != null) {
                    this.isReady = true;
                }
            }
        } else {
            this.isReady = false;
        }
    }
}
