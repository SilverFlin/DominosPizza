/*
 * Utilidades para convertir entre objetos del dominio y DTOs.
 */
package utils;

import domain.Avatar;
import domain.Board;
import domain.BoardTile;
import domain.DominoGame;
import domain.DominoTile;
import domain.Player;
import domain.PlayerTile;
import domain.Pool;
import domain.PoolTile;
import dtos.AvatarDTO;
import dtos.DominoDTO;
import dtos.GameDTO;
import dtos.PlayerDTO;
import dtos.WaitingRoomDTO;
import java.util.ArrayList;
import java.util.Deque;
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

    public static List<Player> parsePlayerList(final List<PlayerDTO> players) {
        List<Player> parsedPlayers = new LinkedList<>();

        for (PlayerDTO p : players) {

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

    public static DominoGame parseDominoGameDTO(final GameDTO game) {
        DominoGame dominoGame = new DominoGame();

        List<DominoDTO> poolTilesDTO = game.getPool();
        List<PoolTile> poolTiles = createPoolTilesList(poolTilesDTO);
        Pool pool = new Pool();
        pool.setDominoes(poolTiles);
        dominoGame.setPool(pool);

        List<DominoDTO> boardTilesDTO = game.getBoard();
        Deque<BoardTile> boardTiles = createBoardTilesList(boardTilesDTO);
        Board board = new Board();
        board.setTiles(boardTiles);
        dominoGame.setBoard(board);

        List<Player> players = Utils.parsePlayerList(game.getPlayers());
        dominoGame.setPlayers(players);

        int initialTiles = game.getInitialTiles();
        dominoGame.setTileAmountConfig(initialTiles);

        return dominoGame;

    }

    public static GameDTO parseDominoGame(final DominoGame dominoGame) {

        List<PoolTile> poolTiles = dominoGame.getPool().getDominoes();
        List<DominoDTO> poolTilesDTO = createPoolDTOlist(poolTiles);

        Deque<BoardTile> boardTiles = dominoGame.getBoard().getTiles();
        List<DominoDTO> boardTilesDTO = createBoardDTOlist(boardTiles);

        List<Player> players = dominoGame.getPlayers();
        List<PlayerDTO> playersDTO = Utils.parsePlayerDTOList(players);

        int initialTiles = dominoGame.getConfig().getTilesPerPlayer();

        return new GameDTO(poolTilesDTO, playersDTO, boardTilesDTO, initialTiles);
    }

    private static List<DominoDTO> createBoardDTOlist(final Deque<BoardTile> tiles) {
        List<DominoDTO> tilesDTO = new LinkedList<>();
        for (DominoTile tile : tiles) {
            tilesDTO.add(new DominoDTO(tile.getLeftValue(), tile.getRightValue()));
        }
        return tilesDTO;
    }

    private static List<DominoDTO> createPoolDTOlist(final List<PoolTile> tiles) {
        List<DominoDTO> tilesDTO = new ArrayList<>();
        for (DominoTile tile : tiles) {
            tilesDTO.add(new DominoDTO(tile.getLeftValue(), tile.getRightValue()));
        }
        return tilesDTO;
    }

    private static Deque<BoardTile> createBoardTilesList(final List<DominoDTO> tiles) {
        Deque<BoardTile> dominoTiles = new LinkedList<>();
        for (DominoDTO tile : tiles) {
            dominoTiles.add(new BoardTile(tile.getLeftValue(), tile.getRightValue()));
        }
        return dominoTiles;
    }

    private static List<PoolTile> createPoolTilesList(final List<DominoDTO> tiles) {
        List<PoolTile> dominoTiles = new ArrayList<>();
        for (DominoDTO tile : tiles) {
            dominoTiles.add(new PoolTile(tile.getLeftValue(), tile.getRightValue()));
        }
        return dominoTiles;
    }
}
