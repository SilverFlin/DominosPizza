package ui.Board;

/**
 *
 */
public class BoardPresenterImpl implements BoardPresenter<BoardView> {

    BoardView view;

    public BoardPresenterImpl(BoardView view) {
        this.view = view;
    }

    @Override
    public void loadBoard() {
        this.view.load();
    }

}
