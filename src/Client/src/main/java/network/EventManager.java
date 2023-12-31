package network;

import domain.DominoGame;
import domain.Player;
import domain.Pool;
import domain.PoolTile;
import edu.itson.eventschema.DuplicatedNameErrorEvent;
import edu.itson.eventschema.Event;
import edu.itson.eventschema.GameOverEvent;
import edu.itson.eventschema.PlayerJoinsEvent;
import edu.itson.eventschema.PlayerLeaveEvent;
import edu.itson.eventschema.UpdateGameEvent;
import edu.itson.eventschema.UpdateWaitingRoomEvent;
import interfaces.GameSystemFacade;
import dtos.GameDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
import edu.itson.eventschema.PlayerReadyEvent;
import edu.itson.eventschema.StartGameEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utils;

/**
 * Gestor de eventos que implementa las interfaces EventProducer y
 * EventConsumer. Actúa como intermediario entre el sistema de juego y la
 * conexión de eventos de red.
 */
public class EventManager implements EventProducer, EventConsumer {

    private final GameSystemFacade gameSystem;
    private final NetworkEventConnection connection;

    private static final Logger LOG = Logger.getLogger(EventManager.class.getName());

    /**
     * Constructor de la clase EventManager.
     *
     * @param connection La conexión de eventos de red.
     * @param gamesystem El sistema de juego.
     */
    public EventManager(final NetworkEventConnection connection, final GameSystemFacade gamesystem) {
        this.connection = connection;
        this.connection.addObserver(this);
        this.gameSystem = gamesystem;
    }

    /**
     * {@inheritDoc}
     *
     * @param playerDTO La información del jugador que se va a unir a la sala de
     * espera.
     */
    @Override
    public void joinToWaitingRoom(final PlayerDTO playerDTO) {
        Player player = Utils.parsePlayerDTO(playerDTO);
        Event updateWaitingRoomEvent = new PlayerJoinsEvent(player);
        this.connection.sendMessage(updateWaitingRoomEvent);
    }

    @Override
    public void startGame(WaitingRoomDTO waitingRoom) {
        // Mover a Dominio?
        DominoGame dominoGame = new DominoGame();
        dominoGame.setPlayers(Utils.parsePlayerList(waitingRoom.getPlayers()));
        dominoGame.setTileAmountConfig(waitingRoom.getInitialTiles());

        Pool pool = new Pool();
        pool.setDominoes(createAllTiles());
        dominoGame.setPool(pool);
        dominoGame.shuffleTiles();

        for (Player player : dominoGame.getPlayers()) {
            for (int i = 0; i < dominoGame.getConfig().getTilesPerPlayer(); i++) {
                dominoGame.takeFromPool(player);
            }
        }

        dominoGame.initTurns();

        Event startGameEvent = new StartGameEvent(dominoGame);
        this.connection.sendMessage(startGameEvent);

    }

    /**
     * {@inheritDoc}
     *
     * @param game El estado actualizado del juego.
     */
    @Override
    public void updateGame(final GameDTO game) {
        DominoGame dominoGame = Utils.parseDominoGameDTO(game);
        Event updateGameEvent = new UpdateGameEvent(dominoGame);
        this.connection.sendMessage(updateGameEvent);
    }

    @Override
    public void gameOver(final GameDTO game) {
        DominoGame dominoGame = Utils.parseDominoGameDTO(game);
        Event gameOverEvent = new GameOverEvent(dominoGame);
        this.connection.sendMessage(gameOverEvent);
    }

    /**
     * {@inheritDoc}
     *
     * Envía un evento de que un jugador ha abandonado y actualiza la interfaz
     * gráfica.
     *
     * @param playerDTO La información del jugador que se va a ir.
     */
    @Override
    public void playerLeaves(final PlayerDTO playerDTO) {

        Player player = Utils.parsePlayerDTO(playerDTO);
        Event playerLeaves = new PlayerLeaveEvent(player);

        this.connection.sendMessage(playerLeaves);
    }

    /**
     * Envia el evento de que esta Listo el jugador
     *
     * @param player La informacion del jugador que esta listo
     */
    @Override
    public void playerIsReady(PlayerDTO player) {

        Player myPlayer = Utils.parsePlayerDTO(player);
        Event playerIsReady = new PlayerReadyEvent(myPlayer);
        this.connection.sendMessage(playerIsReady);

    }

    /**
     * {@inheritDoc}
     *
     * @param event El evento que se va a consumir.
     */
    @Override
    public void consumeEvent(final Event event) {

        if (event instanceof DuplicatedNameErrorEvent) {
            this.gameSystem.showInvalidNameError();
        } else if (event instanceof GameOverEvent gameOverEvent) {
            this.gameSystem.gameOver(gameOverEvent.getPayload());
        } else if (event instanceof PlayerJoinsEvent) {
            LOG.log(Level.WARNING, "PlayerJoinsEvent no implementado");
        } else if (event instanceof PlayerLeaveEvent playerLeaveEvent) {
            PlayerDTO playerDTO = Utils.parsePlayer(playerLeaveEvent.getPayload());
            this.gameSystem.removePlayer(playerDTO);
        } else if (event instanceof UpdateGameEvent) {
            this.gameSystem.updateGame(((UpdateGameEvent) event).getPayload());
        } else if (event instanceof UpdateWaitingRoomEvent updateWaitingRoomEvent) {
            DominoGame dominoGame = updateWaitingRoomEvent.getPayload();
            this.gameSystem.updateWaitingRoom(Utils.parseDominoGameToWaitingRoomDTO(dominoGame));
        } else if (event instanceof PlayerReadyEvent) {
            Player player = ((PlayerReadyEvent) event).getPayload();
            PlayerDTO playerDTO = Utils.parsePlayer(player);
            this.gameSystem.setPlayerReady(playerDTO);
        } else if (event instanceof StartGameEvent) {
            DominoGame dominoGame = ((StartGameEvent) event).getPayload();
            this.gameSystem.startGame(dominoGame);
        }

    }

    private static List<PoolTile> createAllTiles() {
        // TODO mover  a dominio
        List<PoolTile> tiles = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                tiles.add(new PoolTile(i, j));
            }
        }

        return tiles;
    }

}
