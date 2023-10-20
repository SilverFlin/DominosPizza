/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.MainMenu;

import ui.Board.BoardPresenter;

/**
 *
 * @author Toled
 */
public interface MainMenuViewListener {

    void setBoardPresenter(BoardPresenter presenter);
    
    void onStartGameButton();

    void onGameReadyButton();
}
