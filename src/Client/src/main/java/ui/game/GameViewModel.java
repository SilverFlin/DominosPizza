/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.game;



public interface GameViewModel {
    public BoardDTO getBoard();
    public PlayerDTO getMyPlayer();
    public int getramainigTileInPool();
    public int getRemainigTileInPool();
    public List<PlayerDTO> getRoom();
}
