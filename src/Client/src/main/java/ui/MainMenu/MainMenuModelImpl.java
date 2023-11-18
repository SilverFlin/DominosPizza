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

/**
 *
 * @author edemb
 */
public class MainMenuModelImpl implements MainMenuModel, MainMenuViewModel {

    private DominoGame dominoGame;
    private Player myPlayer;
    private List<AvatarDTO> avatars;

    public MainMenuModelImpl(final DominoGame dominoGame, final List<AvatarDTO> avatars) {
        this.dominoGame = dominoGame;
        this.avatars = avatars;
    }

    @Override
    public void configurateWaitingRoom(final PlayerDTO myPlayer, final WaitingRoomDTO waitingRoom) {
        this.dominoGame.setPlayers(parsePlayer(waitingRoom.getPlayers()));
        Config config = new Config();
        config.setTilesPerPlayer(waitingRoom.getInitialTiles());
        this.dominoGame.setConfig(config);

        setMyPlayer(myPlayer);
        setPlayerAdmin();
    }

    private List<Player> parsePlayer(final List<PlayerDTO> players) {
        List<Player> parsedPlayers = new LinkedList<>();
        for (PlayerDTO player : players) {
            Player p = new Player();
            p.setAvatar(new Avatar(player.getAvatar().getNombre(), player.getAvatar().getImage()));
            parsedPlayers.add(p);
        }
        return parsedPlayers;

    }

    private List<PlayerDTO> parsePlayerDTO(final List<Player> players) {
        List<PlayerDTO> parsedPlayers = new LinkedList<>();
        for (Player player : players) {
            PlayerDTO p = new PlayerDTO();
            p.setAvatar(new AvatarDTO(player.getAvatar().getName(), player.getAvatar().getImage()));
            parsedPlayers.add(p);
        }
        return parsedPlayers;

    }

    @Override
    public void setPlayerAdmin() {

        if (this.dominoGame.getPlayers().size() == 1) {
            this.myPlayer.setIsAdmin(true);
        } else {
            this.myPlayer.setIsAdmin(false);
        }

    }

    @Override
    public void setMyPlayer(final PlayerDTO player) {
        this.myPlayer = new Player();
        this.myPlayer.setAvatar(new Avatar(player.getAvatar().getNombre(), player.getAvatar().getImage()));
    }

    @Override
    public boolean isReady() {
        return this.dominoGame.startGame();
    }

    @Override
    public List<AvatarDTO> getAvatars() {
        return this.avatars;
    }

    @Override
    public WaitingRoomDTO getWaitingRoom() {
        return new WaitingRoomDTO(parsePlayerDTO(this.dominoGame.getPlayers()), this.dominoGame.getConfig().getTilesPerPlayer());
    }

    @Override
    public void setWaitingRoom(final WaitingRoomDTO waitingRoom) {
        this.dominoGame.setPlayers(parsePlayer(waitingRoom.getPlayers()));
        Config config = new Config();
        config.setTilesPerPlayer(waitingRoom.getInitialTiles());
        this.dominoGame.setConfig(config);
    }

}
