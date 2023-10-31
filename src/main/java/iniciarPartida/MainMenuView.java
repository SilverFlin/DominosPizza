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
public interface MainMenuView {
final MainMenuPresenterImpl mainMenuPresenterImpl=null;
    /**
     * Representa la interacción del usuario, de ir a la pantalla de avatares.
     */
    public void goToAvatarPanel();

    /**
     * Termina la instancia de esta vista, para ser cambiada a otra vista.
     */
    public void close();

    /**
     * Es llamada al recibir cambios del presentador para actualizar la sala de
     * espera.
     *
     * @param viewModel
     */
    public void updateWaitingRoom(MainMenuViewModel viewModel);

    /**
     * Cambia al panel de Lobby.
     *
     * @param viewModel
     */
    public void showLobbyPanel(MainMenuViewModel viewModel);

    /**
     * Muestra al usuario un error de nombre invalido, debido a la existencia de
     * ese nombre en la sala de espera.
     */
    public void showInvalidNameError();

    /**
     * Representa la interacción de usuario, de ir a la sala de espera.
     */
    public void goToWaitingRoom();

    /**
     * Cambia al panel de selección de Avatar.
     */
    public void showAvatarPanel();
}
