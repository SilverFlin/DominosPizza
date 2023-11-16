/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author edemb
 */
public class RouterImpl implements Router {

    MainMenuPresenter presenter;
    LinkedList<PlayerDTO> players;

    public RouterImpl() {
    }

    public RouterImpl(LinkedList<PlayerDTO> players) {
        this.players = players;
    }

    @Override
    public void joinToWaitingRoom(PlayerDTO player) {
        this.players.add(player);
        this.presenter.updateWaitingRoom(new WaitingRoomDTO(players, 0));
    }

    @Override
    public void setMainMenuPresenter(MainMenuPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void newPlayerHasJoined(WaitingRoomDTO waitingRoom) {
        
        this.presenter.newPlayerHasJoined(waitingRoom);
        
    }

}
