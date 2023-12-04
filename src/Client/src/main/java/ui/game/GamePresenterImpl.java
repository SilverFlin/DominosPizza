package ui.game;

import base.BasePresenter;
import domain.DominoGame;
import domain.Player;
import dtos.DominoDTO;
import dtos.GameDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
import exceptions.IllegalBoardStateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.EventProducer;

/**
 *
 */
public class GamePresenterImpl extends BasePresenter implements GamePresenter {

    private final GameView view;
    private final GameModel model;
    private final EventProducer producer;

    private static final Logger LOG = Logger.getLogger(GamePresenterImpl.class.getName());

    public GamePresenterImpl(final GameView view, final GameModel model, final EventProducer producer) {
        this.view = view;
        this.model = model;
        this.producer = producer;
    }

    @Override
    public void putTileInBoard(final DominoDTO tile) {
        try {
            this.model.putTileInBoard(tile);
            this.view.updateGame((GameViewModel) this.model);
//            TODO producer.updateGame(game);
        } catch (IllegalBoardStateException ex) {
            this.view.showInvalidMoveError();
        }

    }

    @Override
    public void updateGame(DominoGame dominoGame) {
        this.model.updateGame(dominoGame);
        this.view.updateGame((GameViewModel) this.model);

    }

    @Override
    public void loadBoard(DominoGame dominoGame, Player myPlayer) {
        this.model.setMyPlayer(myPlayer);
        this.model.updateGame(dominoGame);
        this.view.updateGame((GameViewModel) this.model);

        System.out.println(this.model);

        this.view.open();
    }

    @Override
    public void takeFromPool() {
        this.model.takeFromPool();
        this.view.updateGame((GameViewModel) this.model);
    }

}
