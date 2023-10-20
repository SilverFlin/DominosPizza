package ui.MainMenu;

import data.dominio.Avatar;
import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;
import network.EventRouter;
import ui.Board.BoardPresenter;
import ui.base.Model;

/**
 *
 */
public class MainMenuPresenter implements MainMenuViewListener {

    MainMenuView view;
    BoardPresenter boardPresenter;
    Model model;
    EventRouter eventRouter;

    public MainMenuPresenter(MainMenuView view) {
        this.view = view;
    }

    @Override
    public void setBoardPresenter(final BoardPresenter boardPresenter) {
        this.boardPresenter = boardPresenter;
    }

    @Override
    public void setEventRouter(final EventRouter eventRouter) {
        this.eventRouter = eventRouter;
    }

    @Override
    public void onStartGameButton() {
        if (this.verifyExistentGame()) {
            this.view.displayLobbyPanel();
        } else {
            this.view.displayConfigurationPanel();
        }
    }

    @Override
    public void onGameReadyButton() {
        this.view.close();
        this.boardPresenter.loadBoard();
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setTilesPerPlayer(int cant) {
        model.setTilesPerPlayer(cant);
    }

    @Override
    public void createAvatar(String name, String Image) {
        model.createAvatar(name, Image);
    }

    @Override
    public Avatar getAvatar() {
        return model.getAvatar();
    }

    @Override
    public void createPlayer(Avatar avatar) {
        model.createPlayer(avatar);
    }

    @Override
    public void removePlayer(Player player) {
        model.removePlayer(player);
    }

    @Override
    public void createDominoGame() {
        model.createDominoGame();
    }

    @Override
    public void createTurnController() {
        model.createTurnController();
    }

    @Override
    public DominoGame getDominoGame() {
        return model.getDominoGame();
    }

    @Override
    public boolean verifyExistentGame() {
        return this.eventRouter.isExistentGame();
    }

    @Override
    public void notifyPlayersInLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPlayers(final List<Player> players) {
        this.view.updatePlayers(players);
        this.model.setPlayers(players);
    }

    @Override
    public void notifyPlayers() {
        this.eventRouter.notifyPlayers(this.model.getDominoGame().getPlayers());
    }

    @Override
    public void toggleReadyStatus() {
//        this.model.getPlayer().setStatus();
        System.out.println("TODO");
        this.notifyPlayers();
        this.view.displayBoardView();
    }

}
