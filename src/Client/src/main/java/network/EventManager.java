package network;

import edu.itson.eventschema.Event;
import interfaces.GameSystemFacade;
import ui.Board.GameDTO;
import ui.MainMenu.PlayerDTO;

/**
 *
 */
public class EventManager implements EventProducer, EventConsumer {

    private GameSystemFacade gameSystem;
    private NetworkConnection connection;

    @Override
    public void joinToWaitingRoom(PlayerDTO player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateGame(GameDTO game) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consumeEvent(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
