package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;
import base.BasePresenter;
import network.EventProducer;
import ui.Board.GamePresenter;

/**
 *
 * @author edemb
 */
public class MainMenuPresenterImpl extends BasePresenter implements MainMenuPresenter {

    MainMenuView view;
    MainMenuModel model;
    EventProducer producer;
    PlayerDTO myPlayer;
    GamePresenter gamePresenter;
    WaitingRoomDTO waitingRoom;

    public MainMenuPresenterImpl() {
    }

    public MainMenuPresenterImpl(MainMenuView view, MainMenuModel model, EventProducer producer, GamePresenter gamePresenter) {
        this.view = view;
        this.model = model;
        this.producer = producer;
        this.gamePresenter = gamePresenter;
    }

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public void setModel(MainMenuModel model) {
        this.model = model;
    }

    @Override
    public void goToAvatarPanel() {
        view.showAvatarPanel((MainMenuViewModel) model);
    }

    @Override
    public void goToWaitingRoom(PlayerDTO player) {
        this.myPlayer = player;
        this.producer.joinToWaitingRoom(player);

    }

    @Override
    public void showInvalidNameError() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateWaitingRoom(WaitingRoomDTO waitingRoom) {
        this.waitingRoom = waitingRoom;
        this.model.configurateWaitingRoom(myPlayer, waitingRoom);
        this.view.showLobbyPanel((MainMenuViewModel) model);

    }

    @Override
    public void newPlayerHasJoined(WaitingRoomDTO waitingRoom) {
        this.waitingRoom = waitingRoom;
        model.setWaitingRoom(waitingRoom);
        if (model.isReady()) {

            gamePresenter.loadBoard(waitingRoom, myPlayer);
            view.close();
        } else {

            view.updateWaitingRoom((MainMenuViewModel) this.model);

        }

    }

    @Override
    public void foreStart() {
        gamePresenter.loadBoard(this.waitingRoom, myPlayer);
        view.close();
    }

}
