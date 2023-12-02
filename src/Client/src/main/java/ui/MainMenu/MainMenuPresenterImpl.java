package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;
import base.BasePresenter;
import java.util.ArrayList;
import java.util.List;
import network.EventProducer;
import ui.game.GamePresenter;

/**
 * Implementación concreta de la interfaz {@link MainMenuPresenter} que actúa
 * como presentador para la pantalla principal del menú.
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

    /**
     * Constructor por defecto de la clase MainMenuPresenterImpl.
     */
    public MainMenuPresenterImpl() {

    }

    /**
     * Constructor de la clase MainMenuPresenterImpl.
     *
     * @param view La vista asociada al presentador.
     * @param model El modelo asociado al presentador.
     * @param producer El productor de eventos.
     * @param gamePresenter El presentador del juego.
     */
    public MainMenuPresenterImpl(MainMenuView view, MainMenuModel model, EventProducer producer, GamePresenter gamePresenter) {
        this.view = view;
        this.model = model;
        this.producer = producer;
        this.gamePresenter = gamePresenter;
        this.view.open();
    }

    /**
     * Establece la vista asociada al presentador.
     *
     * @param view La vista a establecer.
     */
    public void setView(MainMenuView view) {
        this.view = view;
    }

    /**
     * Establece el modelo asociado al presentador.
     *
     * @param model El modelo a establecer.
     */
    public void setModel(MainMenuModel model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void goToAvatarPanel() {
        view.showAvatarPanel((MainMenuViewModel) model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void goToWaitingRoom(PlayerDTO player) {
        this.myPlayer = player;
        this.producer.joinToWaitingRoom(player);
        this.view.displayWaitingRoomPanel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showInvalidNameError() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateWaitingRoom(WaitingRoomDTO waitingRoom) {
        this.waitingRoom = waitingRoom;
        this.model.configurateWaitingRoom(myPlayer, waitingRoom);
        this.view.showLobbyPanel((MainMenuViewModel) model);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void foreStart() {
        if (this.waitingRoom == null) {
            this.waitingRoom = new WaitingRoomDTO();
            this.waitingRoom.setPlayers(new ArrayList<>(List.of(this.myPlayer)));
        }
        gamePresenter.loadBoard(this.waitingRoom, myPlayer);
        view.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playerLeaves() {
        this.producer.playerLeaves(myPlayer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePlayer(final PlayerDTO player) {
        this.model.removePlayer(player);
        this.view.updateWaitingRoom((MainMenuViewModel) this.model);
    }

    /**
     * Pone al jugador en estado de Ready
     *
     * @param player Jugador a poner en Ready
     */
    @Override
    public void setMyPlayerReady() {
        model.setMyPlayerReady();
        PlayerDTO myPlayer = model.getMyPlayer();
        this.producer.playerIsReady(myPlayer);
        // this.updateWaitingRoom(waitingRoom);
    }

    @Override
    public void setPlayerReady(PlayerDTO player) {

        model.setPlayerReady(player);

    }
}
