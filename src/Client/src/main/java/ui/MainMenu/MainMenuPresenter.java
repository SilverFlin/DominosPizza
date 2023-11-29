package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public interface MainMenuPresenter {

    /**
     * Es el método por el cual la vista le avisa al presentador de que el
     * usuario quiere cambiar al panel Avatar.
     */
    public void goToAvatarPanel();

    /**
     * Es el método por el cual la vista le avisa al presentador de que el
     * usuario quiere cambiar al panel de la sala de espera.
     *
     * @param player
     */
    public void goToWaitingRoom(PlayerDTO player);

    /**
     * Es el método que usa el Router para avisarle al presentador de que no se
     * puede usar el nombre proporcionado.
     */
    public void showInvalidNameError();

    /**
     * Es el método por el cual el Router le manda nueva información al
     * presentador.
     * @param waitingRoom
     */
    public void updateWaitingRoom(WaitingRoomDTO waitingRoom);

    public void newPlayerHasJoined(WaitingRoomDTO waitingRoom);

    public void foreStart();
    /**
     * Pone al jugador en estado de Ready
     * @param player Jugador a poner en Ready
     */
    public void setPlayerReady(PlayerDTO player);
}