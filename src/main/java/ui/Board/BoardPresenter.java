package ui.Board;

import ui.base.Presenter;
import ui.base.View;

/**
 *
 * @param <V>
 */
public interface BoardPresenter<V extends BoardView> extends Presenter<View> {

    void loadBoard();
}
