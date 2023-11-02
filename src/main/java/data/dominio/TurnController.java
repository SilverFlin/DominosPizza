/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

import java.util.List;


import java.util.Stack;

/**
 *
 * @author edemb
 */
public class TurnController {

    List<Player> players;

    public TurnController() {
    }

    public TurnController(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

      public void changeTurn(Stack<Player> nplayers){
    
    nplayers.add(nplayers.pop());
         
}
}
