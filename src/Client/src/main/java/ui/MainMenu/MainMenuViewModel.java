/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.MainMenu;

import java.util.List;
import network.EventRouter;
import ui.Board.BoardPresenter;
import ui.base.Model;

/**
 *
 * @author Toled
 */
 interface MainMenuViewModel {

    /**
     * Cambia al panel de selección de Avatar.
     */
    public  List<PlayerDTO> getAvatars();
    /**
     * Regresa la información del jugador actual.
     */
    public PlayerDTO getMyPlayer();
    /**
     * Regresa información de la sala de espera.
     */
    public WaitingRoomDTO getWaitingRoom();
}
