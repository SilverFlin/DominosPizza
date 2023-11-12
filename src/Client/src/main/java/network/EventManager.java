package network;

import domain.Avatar;
import domain.Player;
import edu.itson.eventschema.DuplicatedNameErrorEvent;
import edu.itson.eventschema.Event;
import edu.itson.eventschema.GameOverEvent;
import edu.itson.eventschema.PlayerJoinsEvent;
import edu.itson.eventschema.PlayerLeaveEvent;
import edu.itson.eventschema.UpdateGameEvent;
import edu.itson.eventschema.UpdateWaitingRoomEvent;
import interfaces.GameSystemFacade;
import ui.Board.GameDTO;
import ui.MainMenu.AvatarDTO;
import ui.MainMenu.PlayerDTO;

/**
 * Gestor de eventos que implementa las interfaces EventProducer y
 * EventConsumer. Actúa como intermediario entre el sistema de juego y la
 * conexión de eventos de red.
 */
public class EventManager implements EventProducer, EventConsumer {

    private final GameSystemFacade gameSystem;
    private final NetworkEventConnection connection;

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
            throw new UnsupportedOperationException("Not supported yet.");
        } else if (event instanceof PlayerJoinsEvent) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else if (event instanceof PlayerLeaveEvent) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else if (event instanceof UpdateGameEvent) {
            throw new UnsupportedOperationException("Not supported yet.");
//            this.gameSystem.updateGame(((UpdateGameEvent) event).getPayload());
        } else if (event instanceof UpdateWaitingRoomEvent) {
            throw new UnsupportedOperationException("Not supported yet.");
//            this.gameSystem.updateGame(((UpdateWaitingRoomEvent) event).getPayload());
        }

    }

}
