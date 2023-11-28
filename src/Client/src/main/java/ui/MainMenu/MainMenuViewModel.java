package ui.MainMenu;

import dtos.WaitingRoomDTO;
import dtos.AvatarDTO;
import java.util.List;

/**
 * Interfaz que define la estructura del modelo de vista para la pantalla principal del menú.
 */
public interface MainMenuViewModel {

    /**
     * Obtiene la lista de avatares disponibles para seleccionar.
     *
     * @return La lista de avatares.
     */
    public List<AvatarDTO> getAvatars();

    /**
     * Obtiene la información de la sala de espera.
     *
     * @return La información de la sala de espera.
     */
    public WaitingRoomDTO getWaitingRoom();

    /**
     * Verifica si el usuario actual es un administrador.
     *
     * @return true si el usuario es un administrador, false en caso contrario.
     */
    public boolean isAdmin();
}
