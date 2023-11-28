package network;

import domain.Avatar;
import domain.DominoGame;
import domain.Player;
import edu.itson.eventschema.DuplicatedNameErrorEvent;
import edu.itson.eventschema.Event;
import edu.itson.eventschema.GameOverEvent;
import edu.itson.eventschema.PlayerJoinsEvent;
import edu.itson.eventschema.PlayerLeaveEvent;
import edu.itson.eventschema.UpdateGameEvent;
import edu.itson.eventschema.UpdateWaitingRoomEvent;
import interfaces.GameSystemFacade;
import dtos.GameDTO;
import dtos.AvatarDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
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
        Player player = new Player();

        // TODO necesita casteo?
        AvatarDTO avatarDTO = playerDTO.getAvatar();
        Avatar avatar = new Avatar(avatarDTO.getNombre(), avatarDTO.getImage());
        player.setAvatar(avatar);

        Event updateWaitingRoomEvent = new PlayerJoinsEvent(player);
        this.connection.sendMessage(updateWaitingRoomEvent);
    }

    /**
     * {@inheritDoc}
     *
     * @param game El estado actualizado del juego.
     */
    @Override
    public void updateGame(GameDTO game) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        } else if (event instanceof PlayerLeaveEvent) {
            LOG.log(Level.WARNING, "PlayerLeaveEvent no implementado");
        } else if (event instanceof UpdateGameEvent) {
            LOG.log(Level.WARNING, "UpdateGameEvent no implementado");
//            this.gameSystem.updateGame(((UpdateGameEvent) event).getPayload());
        } else if (event instanceof UpdateWaitingRoomEvent updateWaitingRoomEvent) {
            LOG.log(Level.WARNING, "------>>UpdateWaitingRoomEvent implementado<<------");
            DominoGame dominoGame = updateWaitingRoomEvent.getPayload();
            this.gameSystem.updateWaitingRoom(Utils.parseDominoGameToWaitingRoomDTO(dominoGame));
        }

    }

}
