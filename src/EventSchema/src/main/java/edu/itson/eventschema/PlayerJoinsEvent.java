package edu.itson.eventschema;

import domain.Player;

/**
 * Clase que representa un evento de entrada de jugador en el sistema. Este
 * evento contiene una instancia de Player que representa al jugador que ha
 * entrado al juego.
 */
public class PlayerJoinsEvent extends Event<Player> {

    /**
     * Constructor de la clase PlayerJoinsEvent.
     *
     * @param payload Objeto Player que representa al jugador que ha entrado al
     * juego.
     */
    public PlayerJoinsEvent(final Player payload) {
        super(payload);
        this.type = EventType.PLAYER_LEAVE;
    }

}
