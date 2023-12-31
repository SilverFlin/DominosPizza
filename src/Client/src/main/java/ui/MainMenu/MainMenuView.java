package ui.MainMenu;

import java.util.List;

public interface MainMenuView {

    /**
     * Termina la instancia de esta vista, para ser cambiada a otra vista.
     */
    public void close();

    /**
     * Inicia la instancia de la vista.
     */
    public void open();

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
     * Cambia al panel de selección de Avatar.
     */
    public void showAvatarPanel(MainMenuViewModel viewModel);

    public void setPresenter(MainMenuPresenter presenter);

    public void setPlayerSetupPanel(final PlayerSetupPanel playerSetupPanel);

    public void displayPlayerSetupPanel();

    public void setWaitingRoomPanel(final WaitingRoomJPanel waitingRoomPanel);

    void displayWaitingRoomPanel();

    public void setMenuPanel(final MenuJPanel menuPanel);

    public void displayMenuPanel();

    public void load();

}
