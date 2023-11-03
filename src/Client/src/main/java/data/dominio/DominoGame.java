/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

import java.util.List;

/**
 *
 * @author edemb
 */
public class DominoGame {

    Pool pool;
    Config config;
    List<Player> players;
    TurnController turnController;
    Board board;

    public DominoGame() {
    }

    public void shufflePlayers() throws Exception {
        throw new Exception("No sirve wey!!!!!!");

    }

    public void changeTurn() throws Exception {
        throw new Exception("No sirve wey!!!!!!");

    }

    /**
     * Agrega un jugador al juego que no esté ya agregado.
     * @param player Objeto que representa un jugador/Player
     */
    public void addPlayer(Player player) {
        if(!players.isEmpty())
            for(var p : players)
                if(p.getAvatar().getName().compareTo(player.getAvatar().getName())==0)
                    return;
        players.add(player);
        
    }

    public DominoGame getInstance() {
        return this;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public void setTurnController(TurnController turnController) {
        this.turnController = turnController;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
