/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author edemb
 */
public class DominoGame {

    boolean isReady;
    Pool pool;
    Board board;
    Config config;
    LinkedList<Player> players;
    TurnController turnController;

    private static DominoGame dominoGame;

    private DominoGame() {
    }

    public boolean isIsReady() {
        return isReady;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public void setTurnController(TurnController turnController) {
        this.turnController = turnController;
    }

    public void sifflePlayer() {
        Collections.shuffle(players);
    }

    public void changeTurn() {

        this.turnController.changeTurn(players);

    }

    public void addPlayer(Player player) {
        if (!players.isEmpty()) {
            for (var p : players) {
                if (p.getAvatar().getName().compareTo(player.getAvatar().getName()) == 0) {
                    return;
                }
            }
        }
        players.add(player);

    }

    public static DominoGame getInstance() {
        if (DominoGame.dominoGame == null) {
            DominoGame.dominoGame = new DominoGame();
        }
        return DominoGame.dominoGame;
    }

    public void setTileAmountConfig(int cantTile) {
        this.config.setTilesPerPlayer(cantTile);
    }

    public boolean startGame() {

        for (Player player : this.dominoGame.getPlayers()) {
            if (!player.isReady) {
                return false;
            }
        }
        return true;
    }

    public void putTileBoard(DominoTile tile) {
        this.board.putTile(tile);
    }

    public void takeFromPool(Player player) {
        player.addTile(this.pool.takeTile());
    }

}
