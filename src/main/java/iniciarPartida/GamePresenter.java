/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciarPartida;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public interface GamePresenter {
    /**
     * 
     * @param waitingRoom
     * @param player 
     */
    public void loadBoard(WaitingRoomDTO waitingRoom,PlayerDTO player);
}
