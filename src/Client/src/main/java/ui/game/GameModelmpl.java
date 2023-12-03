package ui.game;

import dtos.DominoDTO;
import domain.Board;
import domain.BoardTile;
import domain.DominoGame;
import domain.Player;
import domain.Pool;
import dtos.AvatarDTO;
import dtos.OpponentDTO;
import java.util.ArrayList;
import java.util.List;
import dtos.PlayerDTO;
import utils.Utils;

/**
 *
 *
 */
public class GameModelmpl implements GameModel, GameViewModel {

    private DominoGame dominoGame;
    private Player myPlayer;

    public GameModelmpl() {
    }

    @Override
    public void setMyPlayer(final Player myPlayer) {
        this.myPlayer = myPlayer;
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
    public void updateGame(final DominoGame dominoGame) {
        this.dominoGame = dominoGame;
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
        return Utils.parsePlayer(this.myPlayer);
    }

    @Override
    public int getRemainingTilesInPool() {
        Pool pool = this.dominoGame.getPool();
        return pool.getDominoes().size();
    }

    @Override
    public List<OpponentDTO> getRoom() {
        List<Player> players = this.dominoGame.getPlayers();
        List<OpponentDTO> opponentDTOs = new ArrayList<>();

        for (Player player : players) {
            if (player.equals(this.myPlayer)) {
                continue;
            }
            OpponentDTO opponent = new OpponentDTO();
            opponent.setTilesLeft(player.getTilesInHand().size());
            opponent.setAvatar(new AvatarDTO(player.getAvatar().getName(), player.getAvatar().getImage()));
            opponentDTOs.add(opponent);

        }

        return opponentDTOs;
    }

    @Override
    public String toString() {
        List<DominoDTO> boardTiles = this.getBoard();
        PlayerDTO player = this.getMyPlayer();
        int remainingTilesPool = this.getRemainingTilesInPool();
        List<OpponentDTO> opponents = this.getRoom();

        return "Game View Model\n"
                + "List<DominoDTO> boardTiles = " + boardTiles + "\n"
                + "PlayerDTO myPlayer = " + player + "\n"
                + "remainingPool = " + remainingTilesPool + "\n"
                + "List<OpponentDTO> = " + opponents + "\n";
    }

}
