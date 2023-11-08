/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.MainMenu;

/**
 *
 * @author edemb
 */
public interface Router {
    public void joinToWaitingRoom(PlayerDTO player);
    public void setMainMenuPresenter(MainMenuPresenter presenter);
    public void newPlayerHasJoined(WaitingRoomDTO waitingRoom);
}
