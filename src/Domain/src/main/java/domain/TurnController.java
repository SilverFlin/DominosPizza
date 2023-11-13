package domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que controla el cambio de turnos entre jugadores.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos TurnController.
 */
public class TurnController implements Serializable {

    /**
     * Constructor de la clase TurnController.
     */
    public TurnController() {
    }

    /**
     * Cambia el turno de los jugadores en la lista dada.
     *
     * @param players Lista de jugadores.
     * @return Lista de jugadores con el turno cambiado.
     */
    public List<Player> changeTurn(final List<Player> players) {
        LinkedList<Player> sortedPlayers = new LinkedList<>(List.copyOf(players));
        Player player = sortedPlayers.pop();
        sortedPlayers.addLast(player);
        return sortedPlayers;
    }
}
