package ui.game;

import base.BasePresenter;
import dtos.DominoDTO;
import dtos.GameDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
import java.util.List;

/**
 *
 */
public class GamePresenterImpl extends BasePresenter implements GamePresenter {

    private final GameView view;
    private final GameModel model;

    public GamePresenterImpl(final GameView view, final GameModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void putTileInBoard(final DominoDTO tile) {
        this.model.putTileInBoard(tile);
        this.view.updateGame((GameViewModel) this.model);
    }

    @Override
    public void updateGame(GameDTO game) {
        this.model.updateGame(game);
        this.view.updateGame((GameViewModel) this.model);

    }

    @Override
    public void loadBoard(WaitingRoomDTO waitingRoom, PlayerDTO myPlayer) {
        List<PlayerDTO> players = waitingRoom.getPlayers();

        // TODO crear y repartir fichas (en modelo)
        System.out.println("GamePresenterImpl.loadBoard() cargando listas vacias");
        GameDTO gameDTO = new GameDTO(null, players, null, waitingRoom.getInitialTiles());

        this.model.updateGame(gameDTO);
        this.view.updateGame((GameViewModel) this.model);
    }

    @Override
    public void takeFromPool() {
        this.model.getTileFromPool();
        this.view.updateGame((GameViewModel) this.model);
    }

}
