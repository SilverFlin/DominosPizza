/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import domain.DominoGame;
import domain.Player;
import dtos.AvatarDTO;
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
        waitingRoomDTO.setPlayers(parsePlayerDTO(dominoGame.getPlayers()));
        return waitingRoomDTO;
    }

    public static List<PlayerDTO> parsePlayerDTO(final List<Player> players) {
        List<PlayerDTO> parsedPlayers = new LinkedList<>();
        for (Player player : players) {
            PlayerDTO p = new PlayerDTO();
            p.setAvatar(new AvatarDTO(player.getAvatar().getName(), player.getAvatar().getImage()));
            parsedPlayers.add(p);
        }
        return parsedPlayers;

    }
}
