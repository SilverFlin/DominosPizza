/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.game;

/**
 *
 * @author JIVB
 */
public interface GameModel {
    public DominoDTO getTileFromPool();
    public void putTileInBoard(DominoDTO domino);
    public void takeFromPool(PlayerDTO player);
    public void updateGame(GameDTO game);
}
