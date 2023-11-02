/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.MainMenu;

import java.util.List;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public interface MainMenuModel {
   final MainMenuPresenterImpl mainMenuPresenterImpl=null;
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
    public List<PlayerDTO> setPlayerAdmin();
    /**
     *  Actualiza la sala de espera, 
     * por lo general guando hay cambios nuevos de fuera.
     */
    public void setWaitingRoom();
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
        
        
        
        
        }
