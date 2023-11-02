/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.MainMenu;

import data.dominio.Avatar;
import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;
import network.EventRouter;
import ui.Board.BoardPresenter;
import ui.base.Model;

/**
 *
 * @author Toled
 */
public interface MainMenuViewListener {

    void setBoardPresenter(BoardPresenter presenter);

    void onStartGameButton();

    void onGameReadyButton();

    void notifyPlayers();

    void setModel(Model model);

    void setEventRouter(EventRouter eventRouter);

    void setTilesPerPlayer(int cant);

    void createAvatar(String name, String Image);

    Avatar getAvatar();

    void createPlayer(Avatar avatar);

    void removePlayer(Player player);

    void createDominoGame();

    void createTurnController();

    DominoGame getDominoGame();

    boolean verifyExistentGame();

    void notifyPlayersInLobby();

    void setPlayers(List<Player> players);
    
    void toggleReadyStatus();

}
