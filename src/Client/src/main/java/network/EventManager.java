package network;

import client.GameSystemFacadeImpl;
import domain.Avatar;
import domain.DominoGame;
import domain.Player;
import edu.itson.eventschema.Event;
import edu.itson.eventschema.PlayerJoinsEvent;
import edu.itson.eventschema.UpdateGameEvent;
import interfaces.GameSystemFacade;
import ui.Board.GameDTO;
import ui.MainMenu.AvatarDTO;
import ui.MainMenu.PlayerDTO;

/**
 *
 */
public class EventManager implements EventProducer, EventConsumer {

    private GameSystemFacade gameSystem;
    private NetworkConnection connection;

    public EventManager(final NetworkEventConnection connection) {
        this.connection = connection;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consumeEvent(final Event event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

}
