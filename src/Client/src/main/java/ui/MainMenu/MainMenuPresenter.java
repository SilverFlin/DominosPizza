package ui.MainMenu;

import java.util.List;
import network.EventRouter;
import ui.Board.BoardPresenter;
import ui.base.Model;

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
     */
    public void updateWaitingRoom();

}
