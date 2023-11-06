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
    // ATRIBUTOS
    Pool pool;
    Config config;
    List<Player> players;
    TurnController turnController;
    Board board;

    // CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public DominoGame() {
    }

    // MÉTODOS
    /**
     * Método que baraja los jugadores en el juego
     * @throws Exception
     */
    public void shufflePlayers() throws Exception {
        throw new Exception("No sirve wey!!!!!!");

    }
    /**
     * Método que cambia el turno de un jugador a otro
     * @throws Exception
     */
    public void changeTurn() throws Exception {
        throw new Exception("No sirve wey!!!!!!");

    }
    /**
     * Método que añade un jugador al juego
     * @param player Jugador a añadir
     */
    public void addPlayer(Player player) {
        if(!players.isEmpty())
            for(var p : players)
                if(p.getAvatar().getName().compareTo(player.getAvatar().getName())==0)
                    return;
        players.add(player);
        
    }
    /**
     * Método que obtiene una instancia de la clase DominoGame
     * @return Regresa una instancia de la clase DominoGame
     */
    public DominoGame getInstance() {
        return this;
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene la pila de fichas del juego
     * @return La pila de fichas
     */
    public Pool getPool() {
        return pool;
    }
    /**
     * Método que agrega una pila de fichas al juego
     * @param pool La pila de fichas a agregar
     */
    public void setPool(Pool pool) {
        this.pool = pool;
    }
    /**
     * Método que obtiene las configuraciones del juego
     * @return Las configuraciones actuales del juego
     */
    public Config getConfig() {
        return config;
    }
    /**
     * Método que permite añadir configuraciones al juego actual
     * @param config Configuraciones a añadir
     */
    public void setConfig(Config config) {
        this.config = config;
    }
    /**
     * Método que obtiene los jugadores del juego
     * @return Una lista de los jugadores actuales
     */
    public List<Player> getPlayers() {
        return players;
    }
    /**
     * Método que agregar los jugadores de una lista de jugadores
     * @param players Jugadores a añadir
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    /**
     * Método que obtiene el controlador de turnos
     * @return El controlador de turnos
     */
    public TurnController getTurnController() {
        return turnController;
    }
    /**
     * Método que permite añadir un controlador de turnos
     * @param turnController Controlador a añadir
     */
    public void setTurnController(TurnController turnController) {
        this.turnController = turnController;
    }
    /**
     * Método que obtiene el tablero del juego
     * @return El tablero del juego
     */
    public Board getBoard() {
        return board;
    }
    /**
     * Método que asigna un tablero al juego
     * @param board Tablero a asignar
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}