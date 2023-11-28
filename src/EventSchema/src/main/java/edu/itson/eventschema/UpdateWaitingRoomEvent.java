package edu.itson.eventschema;

import domain.DominoGame;

/**
 * Clase que representa un evento de actualización de la sala de espera en el
 * sistema. Este evento contiene una instancia de DominoGame que representa el
 * estado actual de la sala de espera.
 */
public class UpdateWaitingRoomEvent extends Event<DominoGame> {

    /**
     * Constructor de la clase UpdateWaitingRoomEvent.
     *
     * @param payload Objeto DominoGame que representa el estado actual de la
     * sala de espera.
     */
    public UpdateWaitingRoomEvent(final DominoGame payload) {
        super(payload);
        this.type = EventType.UPDATE_WAITINGROOM;
    }
}