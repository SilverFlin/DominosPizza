package ui.MainMenu;

import data.dominio.Avatar;
import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;
import ui.Board.BoardPresenter;
import ui.base.Model;

/**
 *
 */
public class MainMenuPresenter implements MainMenuViewListener {

    MainMenuView view;
    BoardPresenter boardPresenter;
    Model model;

    public MainMenuPresenter(MainMenuView view) {
        this.view = view;
    }

    public void setBoardPresenter(final BoardPresenter boardPresenter) {
        this.boardPresenter = boardPresenter;
    }

    @Override
    public void onStartGameButton() {
        throw new UnsupportedOperationException("Not supported yet.");
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

}
