package edu.itson.eventschema;

import domain.DominoGame;

/**
 * Clase que representa un evento de actualización del juego en el sistema. Este
 * evento contiene una instancia de DominoGame que representa el estado actual
 * del juego.
 */
public class UpdateGameEvent extends Event<DominoGame> {

    /**
     * Constructor de la clase UpdateEvent.
     *
     * @param payload Objeto DominoGame que representa el estado actual del
     * juego.
     */
    public UpdateGameEvent(final DominoGame payload) {
        super(payload);
        this.type = EventType.UPDATE_GAME;
    }

}
