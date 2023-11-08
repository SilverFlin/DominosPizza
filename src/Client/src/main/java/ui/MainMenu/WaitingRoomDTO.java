/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author edemb
 */
public class WaitingRoomDTO {
    private LinkedList<PlayerDTO> players;
    private int initialTiles;

    public WaitingRoomDTO() {
    }

    public WaitingRoomDTO(LinkedList<PlayerDTO> players, int initialTiles) {
        this.players = players;
        this.initialTiles = initialTiles;
    }

    public LinkedList<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(LinkedList<PlayerDTO> players) {
        this.players = players;
    }

    public int getInitialTiles() {
        return initialTiles;
    }

    public void setInitialTiles(int initialTiles) {
        this.initialTiles = initialTiles;
    }
    
    
}
