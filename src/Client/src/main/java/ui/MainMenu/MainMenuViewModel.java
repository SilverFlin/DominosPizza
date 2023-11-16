/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.AvatarDTO;
import java.util.List;

/**
 *
 * @author Toled
 */
interface MainMenuViewModel {

    /**
     * Cambia al panel de selección de Avatar.
     */
    public List<AvatarDTO> getAvatars();

    /**
     * Regresa información de la sala de espera.
     */
    public WaitingRoomDTO getWaitingRoom();
}
