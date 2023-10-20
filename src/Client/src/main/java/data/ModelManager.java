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
    // ATRIBUTOS
    Config configuration;
    Avatar avatar;
    Player player;
    TurnController turnController;
    List<Player> players;
    DominoGame dominoGame;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa los atributos de la clase
     */
    public ModelManager() {
        configuration = new Config();
        turnController = new TurnController();
        players = new ArrayList<>();
        this.dominoGame = new DominoGame();
    }

    // MÉTODOS
    /**
     * Método que asigna la cantidad de fichas a cada jugador
     */
    @Override
    public void setTilesPerPlayer(int cant) {
        this.configuration.setTilesPerPlayer(cant);
    }
    /**
     * Método que permite crear un nuevo avatar con nombre y foto de perfil
     */
    @Override
    public void createAvatar(String name, String image) {
        Avatar newAvatar = new Avatar();
        newAvatar.setName(name);
        newAvatar.setImage(image);
        this.avatar = newAvatar;
    }
    /**
     * Método que permite obtener un avatar
     */
    @Override
    public Avatar getAvatar() {
        return this.avatar;
    }
    /**
     * Método que permite crear un nuevo jugador con un avatar asignado
     */
    @Override
    public void createPlayer(Avatar avatar) {
        Player newPlayer = new Player();
        newPlayer.setAvatar(avatar);
        this.player = newPlayer;
        this.players.add(newPlayer);
    }
    /**
     * Método que permite añadir un nuevo jugador
     */
    @Override
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    /**
     * Método que permite remover un jugador
     */
    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }
    /**
     * Método que crea el controlador de turnos para el juego
     */
    @Override
    public void createTurnController() {
        turnController.setPlayers(players);
    }
    /**
     * Método que crea el juego de domino
     */
    @Override
    public void createDominoGame() {
        dominoGame.setConfig(configuration);
        dominoGame.setPlayers(players);
        dominoGame.setTurnController(turnController);
    }
    /**
     * Método que crea una instancia de la clase DominoGame
     */
    @Override
    public DominoGame getDominoGame() {
        return this.dominoGame;
    }
    /**
     * Método que permite asignar los jugadores al juego
     */
    @Override
    public void setPlayers(final List<Player> players) {
        this.dominoGame.setPlayers(players);
    }
    /**
     * Método que permite obtener un jugador específico del juego
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }
}