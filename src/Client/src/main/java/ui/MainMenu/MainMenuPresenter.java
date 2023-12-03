package ui.MainMenu;

import domain.DominoGame;
import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;

/**
 * Interfaz que define las acciones y eventos que puede manejar un presentador
 * de la pantalla principal del menú.
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public interface MainMenuPresenter {

    /**
     * Notifica al presentador que el usuario desea cambiar al panel Avatar.
     */
    public void goToAvatarPanel();

    /**
     * Notifica al presentador que el usuario desea cambiar al panel de la sala
     * de espera.
     *
     * @param player El jugador que desea cambiar al panel de la sala de espera.
     */
    public void goToWaitingRoom(PlayerDTO player);

    /**
     * Muestra un error al presentador indicando que el nombre proporcionado no
     * se puede usar.
     */
    public void showInvalidNameError();

    /**
     * Actualiza la sala de espera con la información proporcionada.
     *
     * @param waitingRoom La información actualizada de la sala de espera.
     */
    public void updateWaitingRoom(WaitingRoomDTO waitingRoom);

    /**
     * Notifica al presentador que un nuevo jugador se ha unido a la sala de
     * espera.
     *
     * @param waitingRoom La información de la sala de espera con el nuevo
     * jugador.
     */
   // public void newPlayerHasJoined(WaitingRoomDTO waitingRoom);

    /**
     * Notifica al presentador que un jugador ha abandonado la sala de espera.
     */
    public void playerLeaves();

    /**
     * Notifica al presentador que se ha iniciado el juego.
     * @param waitingRoomDTO
     * @param cantTiles
     */
    public void start(WaitingRoomDTO waitingRoomDTO);

    /**
     * Remueve un jugador de la sala de espera.
     *
     * @param player El jugador a ser removido.
     */
    public void removePlayer(PlayerDTO player);

    /**
     * Pone al jugador en estado de Ready
     *
     */
    public void setMyPlayerReady();
    
    public void setPlayerReady(PlayerDTO player);
    
    public void startGame(DominoGame dominoGame);
    
    
}
