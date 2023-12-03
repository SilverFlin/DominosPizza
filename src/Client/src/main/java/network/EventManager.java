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
        System.out.println("SE REPARTIERON LAS FICHAS A LOS JUGADORES");
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
        throw new UnsupportedOperationException("Not supported yet.");
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
        } else if (event instanceof GameOverEvent) {
            LOG.log(Level.WARNING, "GameOverEvent no implementado");
        } else if (event instanceof PlayerJoinsEvent) {
            LOG.log(Level.WARNING, "PlayerJoinsEvent no implementado");
        } else if (event instanceof PlayerLeaveEvent playerLeaveEvent) {
            LOG.log(Level.INFO, "------>>PlayerLeaveEvent implementado<<------");
            PlayerDTO playerDTO = Utils.parsePlayer(playerLeaveEvent.getPayload());
            this.gameSystem.removePlayer(playerDTO);
        } else if (event instanceof UpdateGameEvent) {
            LOG.log(Level.WARNING, "UpdateGameEvent no implementado");
//            this.gameSystem.updateGame(((UpdateGameEvent) event).getPayload());
        } else if (event instanceof UpdateWaitingRoomEvent updateWaitingRoomEvent) {
            LOG.log(Level.INFO, "------>>UpdateWaitingRoomEvent implementado<<------");
            DominoGame dominoGame = updateWaitingRoomEvent.getPayload();
            this.gameSystem.updateWaitingRoom(Utils.parseDominoGameToWaitingRoomDTO(dominoGame));
        } else if (event instanceof PlayerReadyEvent) {
            LOG.log(Level.WARNING, "PlayerReadyEventimplementado");
            Player player = ((PlayerReadyEvent) event).getPayload();
            PlayerDTO playerDTO = Utils.parsePlayer(player);
            this.gameSystem.setPlayerReady(playerDTO);
        } else if (event instanceof StartGameEvent) {
            DominoGame dominoGame = ((StartGameEvent) event).getPayload();
            System.out.println("StartGameEvent recivido");
            this.gameSystem.startGame(dominoGame);
        }

    }

    public static List<PoolTile> createAllTiles() {
        List<PoolTile> tiles = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                PoolTile tile = new PoolTile(i, j);
                tiles.add(tile);
                if (i != j) {
                    PoolTile reverseTile = new PoolTile(j, i);
                    tiles.add(reverseTile);
                }
            }
        }
        return tiles;
    }

}
