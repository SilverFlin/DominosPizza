package ui.game;

import base.BasePresenter;
import domain.DominoGame;
import domain.Player;
import dtos.DominoDTO;
import dtos.PlayerDTO;
import exceptions.IllegalBoardStateException;
import java.util.logging.Logger;
import network.EventProducer;
import utils.Utils;

/**
 *
 */
public class GamePresenterImpl extends BasePresenter implements GamePresenter {

    private final GameView view;
    private final GameModel model;
    private final EventProducer producer;
    private Player myPlayer;

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

            this.producer.updateGame(Utils.parseDominoGame(this.model.getDominoGame()));
        } catch (IllegalBoardStateException ex) {
            this.view.showInvalidMoveError();
        }

    }

    @Override
    public void updateGame(final DominoGame dominoGame) {
        this.model.updateGame(dominoGame);

        if (this.model.isGameOver()) {
            this.view.showGameOver((GameViewModel) this.model);
            this.producer.gameOver(Utils.parseDominoGame(this.model.getDominoGame()));
        } else {
            this.view.updateGame((GameViewModel) this.model);
        }
    }

    @Override
    public void gameOver(final DominoGame dominoGame) {
        this.model.updateGame(dominoGame);
        this.view.showGameOver((GameViewModel) this.model);
    }

    @Override
    public void loadBoard(DominoGame dominoGame, Player myPlayer) {
        this.myPlayer = myPlayer;
        this.model.setMyPlayer(myPlayer);
        this.model.updateGame(dominoGame);
        this.view.updateGame((GameViewModel) this.model);
        this.view.open();
    }

    @Override
    public void takeFromPool() {
        if (!this.model.getDominoGame().getCurrentPlayer().equals(this.myPlayer)) {
            return;
        }
        this.model.takeFromPool();
        this.view.updateGame((GameViewModel) this.model);
    }

    @Override
    public void skipTurn() {
        if (this.model.skipTurn(this.myPlayer)) {
            this.view.updateGame((GameViewModel) this.model);
            this.producer.updateGame(Utils.parseDominoGame(this.model.getDominoGame()));
        }
    }

    @Override
    public void removePlayer(final PlayerDTO player) {
        this.model.removePlayer(player);
        this.updateGame(this.model.getDominoGame());
    }

}
