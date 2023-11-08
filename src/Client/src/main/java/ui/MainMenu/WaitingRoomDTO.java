/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

import java.util.List;

/**
 *
 * @author edemb
 */
public class WaitingRoomDTO {
    private List<PlayerDTO> players;
    private int initialTiles;

    public WaitingRoomDTO() {
    }

    public WaitingRoomDTO(List<PlayerDTO> players, int initialTiles) {
        this.players = players;
        this.initialTiles = initialTiles;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    public int getInitialTiles() {
        return initialTiles;
    }

    public void setInitialTiles(int initialTiles) {
        this.initialTiles = initialTiles;
    }
    
    
}
