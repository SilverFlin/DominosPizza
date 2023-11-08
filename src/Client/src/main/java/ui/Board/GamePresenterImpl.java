/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.Board;

import ui.MainMenu.PlayerDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 *
 * @author edemb
 */
public class GamePresenterImpl implements GamePresenter{

    BoardJFrame board = new BoardJFrame();
    
    @Override
    public void loadBoard(WaitingRoomDTO waitingRoom, PlayerDTO player) {
        board.setVisible(true);
    }
    
}
