package data;

import data.dominio.Avatar;
import ui.base.Model;
import data.dominio.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ModelManager implements Model {

    Config configuration;
    Avatar avatar;
    Player player;
    TurnController turnController;
    List<Player> players;
    DominoGame dominoGame;

    public ModelManager() {
        //configuration = new Config();
        turnController = new TurnController();
        players = new ArrayList<>();
        //this.dominoGame = new DominoGame();
    }

    @Override
    public void setTilesPerPlayer(int cant) {
        this.configuration.setTilesPerPlayer(cant);
    }

    @Override
    public void createAvatar(String name, String image) {
        Avatar newAvatar = new Avatar();
        newAvatar.setName(name);
        newAvatar.setImage(image);
        this.avatar = newAvatar;

    }

    @Override
    public Avatar getAvatar() {
        return this.avatar;
    }

    @Override
    public void createPlayer(Avatar avatar) {
       // Player newPlayer = new Player();
      //  newPlayer.setAvatar(avatar);
        //this.player = newPlayer;
        //this.players.add(newPlayer);
    }

    @Override
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void createTurnController() {
        turnController.setPlayers(players);
    }

    @Override
    public void createDominoGame() {
      //  dominoGame.setConfig(configuration);
      //  dominoGame.setPlayers(players);
     //   dominoGame.setTurnController(turnController);
    }

    @Override
    public DominoGame getDominoGame() {
        return this.dominoGame;
    }

    @Override
    public void setPlayers(final List<Player> players) {
       // this.dominoGame.setPlayers(players);
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

}
