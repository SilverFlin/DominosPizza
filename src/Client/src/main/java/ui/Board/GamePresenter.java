/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.Board;

import ui.MainMenu.PlayerDTO;
import ui.MainMenu.WaitingRoomDTO;

/**
 *
 * @author edemb
 */
public interface GamePresenter {
    void loadBoard(WaitingRoomDTO waitingRoom,PlayerDTO player);
}
