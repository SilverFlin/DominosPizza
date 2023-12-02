package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;
import dtos.AvatarDTO;
import domain.Avatar;
import domain.Config;
import domain.DominoGame;
import domain.Player;
import java.util.LinkedList;
import java.util.List;
import utils.Utils;

/**
 * Implementación concreta de la interfaz {@link MainMenuModel} y
 * {@link MainMenuViewModel}.
 */
public class MainMenuModelImpl implements MainMenuModel, MainMenuViewModel {

    private DominoGame dominoGame;
    private Player myPlayer;
    private List<AvatarDTO> avatars;

    /**
     * Constructor de la clase MainMenuModelImpl.
     *
     * @param dominoGame El juego de dominó.
     * @param avatars Lista de avatares disponibles.
     */
    public MainMenuModelImpl(final DominoGame dominoGame, final List<AvatarDTO> avatars) {
        this.dominoGame = dominoGame;
        this.avatars = avatars;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configurateWaitingRoom(final PlayerDTO myPlayer, final WaitingRoomDTO waitingRoom) {
        this.dominoGame.setPlayers(parsePlayer(waitingRoom.getPlayers()));
        Config config = new Config();
        config.setTilesPerPlayer(waitingRoom.getInitialTiles());
        this.dominoGame.setConfig(config);

        setMyPlayer(myPlayer);
        setPlayerAdmin();
    }

    /**
     * Convierte una lista de objetos PlayerDTO a una lista de objetos Player.
     *
     * @param players Lista de jugadores DTO.
     * @return Lista de jugadores convertidos.
     */
    private List<Player> parsePlayer(final List<PlayerDTO> players) {
        List<Player> parsedPlayers = new LinkedList<>();
        for (PlayerDTO player : players) {
            Player p = new Player();
            p.setAvatar(new Avatar(player.getAvatar().getNombre(), player.getAvatar().getImage()));
            parsedPlayers.add(p);
        }
        return parsedPlayers;
    }

    /**
     * Convierte una lista de objetos Player a una lista de objetos PlayerDTO.
     *
     * @param players Lista de jugadores.
     * @return Lista de jugadores DTO convertidos.
     */
    private List<PlayerDTO> parsePlayerDTO(final List<Player> players) {
        List<PlayerDTO> parsedPlayers = new LinkedList<>();
        for (Player player : players) {
            PlayerDTO p = new PlayerDTO();
            p.setAvatar(new AvatarDTO(player.getAvatar().getName(), player.getAvatar().getImage()));
            parsedPlayers.add(p);
        }
        return parsedPlayers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlayerAdmin() {
        if (this.dominoGame.getPlayers().size() == 1) {
            this.myPlayer.setIsAdmin(true);
        } else {
            this.myPlayer.setIsAdmin(false);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMyPlayer(final PlayerDTO player) {
        this.myPlayer = new Player();
        this.myPlayer.setAvatar(new Avatar(player.getAvatar().getNombre(), player.getAvatar().getImage()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isReady() {
        return this.dominoGame.startGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AvatarDTO> getAvatars() {
        return this.avatars;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WaitingRoomDTO getWaitingRoom() {
        return new WaitingRoomDTO(parsePlayerDTO(this.dominoGame.getPlayers()), this.dominoGame.getConfig().getTilesPerPlayer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWaitingRoom(final WaitingRoomDTO waitingRoom) {
        this.dominoGame.setPlayers(parsePlayer(waitingRoom.getPlayers()));
        Config config = new Config();
        config.setTilesPerPlayer(waitingRoom.getInitialTiles());
        this.dominoGame.setConfig(config);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdmin() {
        return this.myPlayer.isAdmin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePlayer(PlayerDTO playerDTO) {
        List<Player> players = this.dominoGame.getPlayers();
        for (Player player : players) {
            if (player.getAvatar().getName().equals(playerDTO.getAvatar().getNombre())) {
                players.remove(player);
                break;
            }
        }
        this.dominoGame.setPlayers(players);
    }

    @Override
    public void setMyPlayerReady() {
        /*List<Player> players = this.dominoGame.getPlayers();
        for (Player p : players) {
            if (p.isReady() != player.isIsReady()) {
                player.setIsReady(true);
            }
        }
        return player;*/
        this.myPlayer.setReady();
    }

    @Override
    public PlayerDTO getMyPlayer() {

        PlayerDTO myPlayerDTO = Utils.parsePlayer(myPlayer);
        return myPlayerDTO;

    }

    @Override
    public void setPlayerReady(PlayerDTO player) {

        for (Player p : this.dominoGame.getPlayers()) {

            if (p.equals(player)) {
                p.setReady();
                break;
            }

        }

    }

    @Override
    public boolean startGame() {

        return this.dominoGame.startGame();
        
    }
}
