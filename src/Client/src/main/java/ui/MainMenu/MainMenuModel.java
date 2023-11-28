/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;
import java.util.List;

/**
 *
 * @author edemb
 */
/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public interface MainMenuModel {
    /**
     * Crea el seguimiento a las instancias del 
     * jugador actual y de la sala de espera.
     * @param myPlayer
     * @param waitingRoom 
     */
    public void configurateWaitingRoom(PlayerDTO myPlayer, WaitingRoomDTO waitingRoom);
/**
 * Asigna al jugador como admin, en caso de que lo sea, 
 * y regresa la lista de jugadores actualizada.
 * @return 
 */
    public void setPlayerAdmin();
    /**
     *  Actualiza la sala de espera, 
     * por lo general guando hay cambios nuevos de fuera.
     */
//    public void setWaitingRoom(WaitingRoomDTO waitingRoom);
/**
 * Inicializa al jugador de la sesión actual.
 * @param player 
 */
    public void setMyPlayer(PlayerDTO player);
    /**
     * En base a la lógica de negocio en el dominio, 
     * regresar true si el estado de actual de la sala de espera 
     * representa que el juego esta listo para iniciar.
     * @return 
     */
    public boolean isReady();


    public void setWaitingRoom(WaitingRoomDTO waitingRoom);

        }
