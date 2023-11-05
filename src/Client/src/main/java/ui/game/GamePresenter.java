/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.game;

/**
 *
 * @author darks
 */
public interface GamePresenter {
    public void putTileInBoard(DominoDTO);
    public void updateGame(GameDTO);
    public void loadBoard(WaitingRoomDTO waitingRoom,PlayerDTO player);
    public void updateGame(GameDTO);
    public boolean validateMove();
    public void takeFromPool(PlayerDTO);
}
