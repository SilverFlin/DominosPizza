/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

import java.util.List;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
class WaitingRoomDTO {
    public List<PlayerDTO> players;
    public int initialTiles;

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
