/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import domain.Avatar;
import domain.DominoGame;
import domain.DominoTile;
import domain.Player;
import dtos.AvatarDTO;
import dtos.DominoDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author edemb
 */
public abstract class Utils {

    public static WaitingRoomDTO parseDominoGameToWaitingRoomDTO(DominoGame dominoGame) {
        WaitingRoomDTO waitingRoomDTO = new WaitingRoomDTO();
        waitingRoomDTO.setInitialTiles(dominoGame.getConfig().getTilesPerPlayer());
        waitingRoomDTO.setPlayers(parsePlayerDTOList(dominoGame.getPlayers()));
        return waitingRoomDTO;
    }

    public static List<PlayerDTO> parsePlayerDTOList(final List<Player> players) {
        List<PlayerDTO> parsedPlayers = new LinkedList<>();
        for (Player player : players) {
            PlayerDTO p = new PlayerDTO();
            p.setAvatar(new AvatarDTO(player.getAvatar().getName(), player.getAvatar().getImage()));
            parsedPlayers.add(p);
        }
        return parsedPlayers;

    }

    public static Player parsePlayerDTO(final PlayerDTO playerDTO) {
        Player player = new Player();

        AvatarDTO avatarDTO = playerDTO.getAvatar();
        Avatar avatar = new Avatar(avatarDTO.getNombre(), avatarDTO.getImage());
        player.setAvatar(avatar);

        player.setIsAdmin(playerDTO.isIsAdmin());

        List<DominoDTO> tiles = playerDTO.getTiles();

        for (DominoDTO tile : tiles) {
            DominoTile dominoTile = new DominoTile(tile.getLeftValue(), tile.getRightValue());
            player.addTile(dominoTile);
        }

        return player;
    }
}
