package edu.itson.eventschema;

import domain.Player;

/**
 * Clase que representa un evento de salida de jugador en el sistema. Este
 * evento contiene una instancia de Player que representa al jugador que ha
 * abandonado el juego.
 */
public class PlayerLeaveEvent extends Event<Player> {

    /**
     * Constructor de la clase PlayerLeaveEvent.
     *
     * @param payload Objeto Player que representa al jugador que ha abandonado
     * el juego.
     */
    public PlayerLeaveEvent(final Player payload) {
        super(payload);
        this.type = EventType.PLAYER_LEAVE;
    }

}
