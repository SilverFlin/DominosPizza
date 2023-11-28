package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.PlayerDTO;

/**
 * Interfaz que define el modelo para la pantalla principal del menú.
 */
public interface MainMenuModel {

    /**
     * Configura las instancias del jugador actual y de la sala de espera.
     *
     * @param myPlayer El jugador actual.
     * @param waitingRoom La sala de espera.
     */
    public void configurateWaitingRoom(PlayerDTO myPlayer, WaitingRoomDTO waitingRoom);

    /**
     * Asigna al jugador como administrador, si lo es, y actualiza la lista de
     * jugadores.
     */
    public void setPlayerAdmin();

    /**
     * Actualiza la sala de espera, generalmente cuando hay cambios nuevos desde
     * fuera.
     *
     * @param waitingRoom La sala de espera actualizada.
     */
    public void setWaitingRoom(WaitingRoomDTO waitingRoom);

    /**
     * Inicializa al jugador de la sesión actual.
     *
     * @param player El jugador de la sesión actual.
     */
    public void setMyPlayer(PlayerDTO player);

    /**
     * Determina si, según la lógica de negocio en el dominio, el juego está
     * listo para iniciar.
     *
     * @return true si el juego está listo para iniciar, false de lo contrario.
     */
    public boolean isReady();

    /**
     * Elimina un jugador de la lista.
     *
     * @param player El jugador a ser eliminado.
     */
    public void removePlayer(PlayerDTO player);
}
