package network;

import client.GameSystemFacadeImpl;
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
 *
 */
public class EventManager implements EventProducer, EventConsumer {

    private GameSystemFacade gameSystem;
    private NetworkEventConnection connection;

    public EventManager(final NetworkEventConnection connection) {
        this.connection = connection;
        this.connection.addObserver(this);
        this.gameSystem = new GameSystemFacadeImpl();

    }

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

    @Override
    public void updateGame(GameDTO game) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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
