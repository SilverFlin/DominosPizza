/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

import java.util.List;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
 interface MainMenuViewModel {
    
    /**
     * Cambia al panel de selección de Avatar.
     */
    public  List<AvatarDTO> getAvatars();
    /**
     * Regresa la información del jugador actual.
     */
    public PlayerDTO getMyPlayer();
    /**
     * Regresa información de la sala de espera.
     */
    public WaitingRoomDTO getWaitingRoom();
}
