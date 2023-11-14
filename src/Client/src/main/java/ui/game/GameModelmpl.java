package ui.game;

import domain.Board;
import domain.DominoGame;
import domain.Player;
import domain.Pool;
import java.util.List;
import ui.Board.GameDTO;
import ui.MainMenu.PlayerDTO;

/**
 *
 *
 */
public class GameModelmpl implements GameModel, GameViewModel {

    private DominoGame dominoGame;
    private Player myPlayer;

    public GameModelmpl() {
    }

    // GameModel
    @Override
    public DominoDTO getTileFromPool() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putTileInBoard(DominoDTO tile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void takeFromPool(PlayerDTO player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateGame(GameDTO game) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // GameViewModel
    @Override
    public BoardDTO getBoard() {
        Board board = this.dominoGame.getBoard();
        BoardDTO boardDTO = new BoardDTO();
        // TODO Parse
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PlayerDTO getMyPlayer() {
        PlayerDTO playerDTO = new PlayerDTO();
        // TODO Parse
        // Necesita tener un atributo de su mano
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getRemainingTilesInPool() {
        Pool pool = this.dominoGame.getPool();
        return pool.getDominoes().size();
    }

    @Override
    public List<PlayerDTO> getRoom() {
        this.dominoGame.getPlayers();
        // todo parse
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
