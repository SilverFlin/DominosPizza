package edu.itson.eventschema;

/**
 * Enumeración que representa los diferentes tipos de eventos en el sistema. Los
 * eventos pueden ser de error, fin del juego, salida del jugador, actualización
 * de la sala de espera o actualización del juego.
 */
public enum EventType {
    /**
     * Tipo de evento para errores en el sistema.
     */
    ERROR,
    /**
     * Tipo de evento para indicar el fin del juego.
     */
    GAME_OVER,
    /**
     * Tipo de evento para cuando un jugador abandona la partida.
     */
    PLAYER_LEAVE,
    /**
     * Tipo de evento para actualizaciones en la sala de espera.
     */
    UPDATE_WAITINGROOM,
    /**
     * Tipo de evento para actualizaciones durante el juego.
     */
    UPDATE_GAME,
    /**
     * Tipo de evento para cuando un jugador entra a la partida.
     */
    PLAYER_JOINS,

    /**
     * Tipo de evento para cuando un jugador esté en estado listo
     */
    PLAYER_READY

}
