package ui.base;

import data.dominio.Avatar;
import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;

/**
 *
 * @author edemb
 */
public interface Model {

    void setTilesPerPlayer(int cant);

    void createAvatar(String name, String Image);

    Avatar getAvatar();
    
    Player getPlayer();

    void createPlayer(Avatar avatar);

    void addPlayer(Player player);

    void removePlayer(Player player);

    void createDominoGame();

    void createTurnController();

    DominoGame getDominoGame();

    void setPlayers(List<Player> players);

}
