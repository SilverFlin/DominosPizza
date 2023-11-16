package ui.game;

import dtos.DominoDTO;
import dtos.GameDTO;
import domain.Avatar;
import domain.Board;
import domain.BoardTile;
import domain.DominoGame;
import domain.Player;
import domain.PlayerTile;
import domain.Pool;
import dtos.OpponentDTO;
import java.util.ArrayList;
import java.util.List;
import dtos.AvatarDTO;
import dtos.PlayerDTO;

/**
 *
 *
 */
public class GameModelmpl implements GameModel, GameViewModel {

    private DominoGame dominoGame;
    private Player myPlayer;

    public GameModelmpl() {
    }

    public void setMyPlayer(final Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    // GameModel
    @Override
    public DominoDTO getTileFromPool() {
        // TODO quitar metodo, se remplazo por takeFromPool()
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public void putTileInBoard(final DominoDTO tile) {
        BoardTile boardTile = new BoardTile(tile.getLeftValue(), tile.getRightValue());
        this.dominoGame.putTileBoard(boardTile);
    }

    @Override
    public void takeFromPool() {
        this.dominoGame.takeFromPool(myPlayer);
    }

    @Override
    public void updateGame(final GameDTO game) {
        if (game.getBoard() != null) {
            List<BoardTile> boardTiles = new ArrayList<>();
            for (DominoDTO tile : game.getBoard()) {
                boardTiles.add(new BoardTile(tile.getLeftValue(), tile.getRightValue()));
            }
            this.dominoGame.getBoard().setTiles(boardTiles);
        }

        // TODO
        var playersDTO = game.getPlayers();
        List<Player> players = new ArrayList<>();
        for (PlayerDTO playerDTO : playersDTO) {
            Player player = new Player();
            Avatar avatar = new Avatar(playerDTO.getAvatar().getNombre(), playerDTO.getAvatar().getImage());
            player.setAvatar(avatar);

//            player.set
        }

//        var players = game.getPlayers();
//        var poolTiles = game.getPoolTiles();
//
//        this.dominoGame.setBoard();
    }

    // GameViewModel
    @Override
    public List<DominoDTO> getBoard() {
        Board board = this.dominoGame.getBoard();
        List<DominoDTO> boardTiles = new ArrayList<>();
        for (BoardTile myTile : board.getTiles()) {
            boardTiles.add(new DominoDTO(myTile.getLeftValue(), myTile.getRightValue()));
        }
        return boardTiles;
    }

    @Override
    public PlayerDTO getMyPlayer() {
        var myTiles = this.myPlayer.getTilesInHand();
        List<DominoDTO> playerHand = new ArrayList<>();
        for (PlayerTile myTile : myTiles) {
            playerHand.add(new DominoDTO(myTile.getLeftValue(), myTile.getRightValue()));
        }
        // TODO
        return null;
    }

    @Override
    public int getRemainingTilesInPool() {
        Pool pool = this.dominoGame.getPool();
        return pool.getDominoes().size();
    }

    @Override
    public List<OpponentDTO> getRoom() {
        this.dominoGame.getPlayers();
        // todo quitar mi jugador
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
