package edu.itson.eventschema;

import domain.DominoGame;

/**
 * Clase que representa un evento de fin del juego en el sistema. Este evento
 * contiene una instancia de DominoGame que representa el estado final del
 * juego.
 */
public class GameOverEvent extends Event<DominoGame> {

    /**
     * Constructor de la clase GameOverEvent.
     *
     * @param payload Objeto DominoGame que representa el estado final del
     * juego.
     */
    public GameOverEvent(final DominoGame payload) {
        super(payload);
        this.type = EventType.GAME_OVER;
    }

}
