/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.models;

import data.dominio.Avatar;
import data.dominio.Config;
import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;

/**
 *
 * @author edemb
 */
public interface Model {

    void setTilesPerPlayer(int cant);

    void createAvatares(String name,String Image);

    List<Avatar> getAvatars();
    
    Avatar getAvatarByIndex(int index);

    void createPlayer(Avatar avatar);

    void addPlayer(Player player);

    void createDominoGame();

    void createTurnController();

    DominoGame getDominoGame();

}
