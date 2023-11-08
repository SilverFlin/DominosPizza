/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.LinkedList;

/**
 *
 * @author edemb
 */
public class TurnController {

    public TurnController() {
    }

    public void changeTurn(LinkedList<Player> players) {

        Player player = players.pop();
        players.addLast(player);

    }
}
