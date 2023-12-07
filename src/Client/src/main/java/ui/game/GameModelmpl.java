package ui.game;

import dtos.DominoDTO;
import domain.Board;
import domain.BoardTile;
import domain.DominoGame;
import domain.Player;
import domain.PlayerTile;
import domain.Pool;
import dtos.AvatarDTO;
import dtos.OpponentDTO;
import java.util.ArrayList;
import java.util.List;
import dtos.PlayerDTO;
import exceptions.IllegalBoardStateException;
import exceptions.InvalidMoveException;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void putTileInBoard(final DominoDTO tile) throws IllegalBoardStateException {
        if (!this.dominoGame.getCurrentPlayer().equals(this.myPlayer)) {
            // If it isn't your turn do nothing.
            return;
        }

        BoardTile boardTile = new BoardTile(tile.getLeftValue(), tile.getRightValue());
        try {

            this.dominoGame.putTileBoard(boardTile);
            this.myPlayer.removeTile(new PlayerTile(tile.getLeftValue(), tile.getRightValue()));
            this.dominoGame.updatePlayer(this.myPlayer);
        } catch (InvalidMoveException ex) {
            throw new IllegalBoardStateException();
        }
    }

    @Override
    public void takeFromPool() {
        this.dominoGame.takeFromPool(myPlayer);
    }

    @Override
    public void updateGame(final DominoGame dominoGame) {
        this.dominoGame = dominoGame;
    }

    @Override
    public DominoGame getDominoGame() {
        return this.dominoGame;
    }

    @Override
    public boolean skipTurn(final Player player) {
        return this.dominoGame.changeTurn(player);
    }

    @Override
    public boolean isGameOver() {
        return this.dominoGame.isGameOver();
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
    public PlayerDTO getActivePlayer() {
        return Utils.parsePlayer(this.dominoGame.getCurrentPlayer());
    }

    @Override
    public SortedMap<AvatarDTO, Integer> getGameResume() {
        SortedMap<Player, Integer> resume = this.dominoGame.getGameResume();
        return Utils.parseGameResume(resume);
    }

    @Override
    public void removePlayer(PlayerDTO playerDTO) {
        if (this.dominoGame == null) {
            return;
        }
        for (Player player : this.dominoGame.getPlayers()) {
            Player playerParsed = Utils.parsePlayerDTO(playerDTO);
            if (player.equals(playerParsed)) {
                this.dominoGame.removePlayer(player);
            }
        }
    }

    @Override
    public String toString() {
        List<DominoDTO> boardTiles = this.getBoard();
        PlayerDTO player = this.getMyPlayer();
        int remainingTilesPool = this.getRemainingTilesInPool();
        List<OpponentDTO> opponents = this.getRoom();
        PlayerDTO activePlayer = this.getActivePlayer();
        String activePlayerStr = " {name=" + activePlayer.getAvatar().getNombre() + ", tiles=" + activePlayer.getTiles().size() + "}";

        return "Game View Model\n"
                + "PlayerDTO myPlayer = " + player + "\n"
                + "remainingPool = " + remainingTilesPool + "\n"
                + "List<OpponentDTO> = " + opponents + "\n"
                + "currentPlayer " + activePlayerStr + "\n";
    }

}
