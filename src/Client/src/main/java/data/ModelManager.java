/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import data.dominio.Avatar;
import data.models.Model;
import data.dominio.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toled
 */
public class ModelManager implements Model {

    Config configuration;
    List<Avatar> avatares;
    TurnController turnController;
    List<Player> players;
    DominoGame dominoGame;

    public ModelManager() {
        configuration = new Config();
        turnController = new TurnController();
        players = new ArrayList<>();
        this.dominoGame = new DominoGame();
        this.avatares = new ArrayList<>();
    }

    @Override
    public void setTilesPerPlayer(int cant) {
        this.configuration.setTilesPerPlayer(cant);
    }

    @Override
    public void createAvatares(String name, String image) {
        Avatar newAvatar = new Avatar();
        newAvatar.setName(name);
        newAvatar.setImage(image);
        this.avatares.add(newAvatar);

    }

    @Override
    public List<Avatar> getAvatars() {
        return this.avatares;
    }

    @Override
    public Avatar getAvatarByIndex(int index) {
        return this.avatares.get(index);
    }

    @Override
    public void createPlayer(Avatar avatar) {
        Player newPlayer = new Player();
        newPlayer.setAvatar(avatar);
        this.players.add(newPlayer);
    }

    @Override
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public void createTurnController() {
        turnController.setPlayers(players);
    }

    @Override
    public void createDominoGame() {
        dominoGame.setConfig(configuration);
        dominoGame.setPlayers(players);
        dominoGame.setTurnController(turnController);
    }

    @Override
    public DominoGame getDominoGame() {
        return this.dominoGame;
    }

}
