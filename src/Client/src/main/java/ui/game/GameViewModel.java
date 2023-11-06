/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.game;

/**
 *
 * @author JIVB
 */
public interface GameViewModel {
    public BoardDTO getBoard();
    public PlayerDTO PlayerDTO();
    public int getRemainigTileInPool();
    public List<PlayerDTO> getRoom();
}
