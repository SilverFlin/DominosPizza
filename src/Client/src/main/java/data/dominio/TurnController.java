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
public class TurnController {
    // ATRIBUTOS
    List<Player> players;

    // CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public TurnController() {
    }
    /**
     * Constructor que inicializa el atributo de la lista de jugadores
     * @param players
     */
    public TurnController(List<Player> players) {
        this.players = players;
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene la lista de jugadores
     * @return La lista de los jugadores
     */
    public List<Player> getPlayers() {
        return players;
    }
    /**
     * Método que permite asignar jugadores al controlador
     * @param players Jugadores a asignar
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // MÉTODOS
    /**
     * Método que permite añadir un jugador al controlador
     * @param player Jugador a añadir
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    /**
     * Método que permite cambiar el turno del juego
     * @throws Exception
     */
    public void changeTurn() throws Exception {
        throw new Exception("No sirve wey!!!!!!");
    }
}