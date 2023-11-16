package dtos;

import java.util.List;

/**
 *
 */
public class WaitingRoomDTO {

    private List<PlayerDTO> players;
    private int initialTiles;

    public WaitingRoomDTO() {
    }

    public WaitingRoomDTO(final List<PlayerDTO> players, final int initialTiles) {
        this.players = players;
        this.initialTiles = initialTiles;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(final List<PlayerDTO> players) {
        this.players = players;
    }

    public int getInitialTiles() {
        return initialTiles;
    }

    public void setInitialTiles(int initialTiles) {
        this.initialTiles = initialTiles;
    }

}
