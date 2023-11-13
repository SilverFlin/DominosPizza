package edu.itson.server;

import edu.itson.eventschema.Event;

/**
 * Interfaz que define la funcionalidad de un productor de eventos.
 */
public interface EventProducer {

    /**
     * Publica un evento.
     *
     * @param event El evento a publicar.
     */
    void publishEvent(Event event);

}
