/*
 * Utilidades para convertir entre objetos del dominio y DTOs.
 */
package utils;

import domain.Avatar;
import domain.DominoGame;
import domain.DominoTile;
import domain.Player;
import domain.PlayerTile;
import dtos.AvatarDTO;
import dtos.DominoDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase abstracta que proporciona utilidades para convertir entre objetos del
 * dominio y DTOs. Contiene métodos estáticos para realizar estas conversiones.
 */
public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Convierte un objeto de tipo DominoGame a un WaitingRoomDTO.
     *
     * @param dominoGame El juego de dominó.
     * @return Un DTO que representa la sala de espera del juego de dominó.
     */
    public static WaitingRoomDTO parseDominoGameToWaitingRoomDTO(DominoGame dominoGame) {
        WaitingRoomDTO waitingRoomDTO = new WaitingRoomDTO();
        waitingRoomDTO.setInitialTiles(dominoGame.getConfig().getTilesPerPlayer());
        waitingRoomDTO.setPlayers(parsePlayerDTOList(dominoGame.getPlayers()));
        return waitingRoomDTO;
    }

    /**
     * Convierte una lista de objetos Player a una lista de PlayerDTO.
     *
     * @param players La lista de jugadores.
     * @return Una lista de DTOs que representan a los jugadores.
     */
    public static List<PlayerDTO> parsePlayerDTOList(final List<Player> players) {
        List<PlayerDTO> parsedPlayers = new LinkedList<>();
        for (Player player : players) {
            PlayerDTO p = new PlayerDTO();
            p.setAvatar(new AvatarDTO(player.getAvatar().getName(), player.getAvatar().getImage()));
            p.setIsAdmin(player.isAdmin());
            p.setIsReady(player.isReady());
            parsedPlayers.add(p);
        }
        return parsedPlayers;
    }
    
    public static List<Player> parsePlayerList(final List<PlayerDTO> players){
        List<Player> parsedPlayers = new LinkedList<>();
        
        for(PlayerDTO p : players){
        
            Player player = new Player();
            player.setAvatar(new Avatar(p.getAvatar().getNombre(), p.getAvatar().getImage()));
            player.setIsAdmin(p.isIsAdmin());
            parsedPlayers.add(player);
        }
        return parsedPlayers;
        
    }

    /**
     * Convierte un objeto PlayerDTO a un objeto Player.
     *
     * @param playerDTO El DTO que representa al jugador.
     * @return El objeto Player convertido.
     */
    public static Player parsePlayerDTO(final PlayerDTO playerDTO) {
        Player player = new Player();

        if (playerDTO == null) {
            return null;
        }
        AvatarDTO avatarDTO = playerDTO.getAvatar();
        Avatar avatar = new Avatar(avatarDTO.getNombre(), avatarDTO.getImage());
        player.setAvatar(avatar);

        player.setIsAdmin(playerDTO.isIsAdmin());

        List<DominoDTO> tiles = playerDTO.getTiles();

        if (tiles != null) {
            for (DominoDTO tile : tiles) {
                DominoTile dominoTile = new DominoTile(tile.getLeftValue(), tile.getRightValue());
                player.addTile(dominoTile);
            }
        }

        return player;
    }

    /**
     * Convierte un objeto Player a un objeto PlayerDTO.
     *
     * @param player El jugador.
     * @return El DTO que representa al jugador convertido.
     */
    public static PlayerDTO parsePlayer(final Player player) {
        PlayerDTO playerDTO = new PlayerDTO();

        if (player == null) {
            return null;
        }

        AvatarDTO avatarDTO = new AvatarDTO(player.getAvatar().getName(), player.getAvatar().getImage());
        playerDTO.setAvatar(avatarDTO);

        playerDTO.setIsAdmin(player.isAdmin());

        List<PlayerTile> tiles = player.getTilesInHand();
        List<DominoDTO> tilesDTO = new ArrayList<>();

        for (PlayerTile tile : tiles) {
            DominoDTO dominoTile = new DominoDTO(tile.getLeftValue(), tile.getRightValue());
            tilesDTO.add(dominoTile);
        }
        playerDTO.setTiles(tilesDTO);

        return playerDTO;
    }
}
