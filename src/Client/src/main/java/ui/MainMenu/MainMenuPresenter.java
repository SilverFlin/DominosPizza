package ui.MainMenu;

import ui.Board.BoardPresenter;

/**
 *
 */
public class MainMenuPresenter implements MainMenuViewListener {

    MainMenuView view;
    BoardPresenter boardPresenter;

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
//        this.boardPresenter.loadBoard();

    }

}
