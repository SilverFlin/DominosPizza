package edu.itson.server;

import edu.itson.eventschema.Event;

/**
 * Interfaz que define la funcionalidad de un consumidor de eventos.
 */
public interface EventConsumer {

    /**
     * Consume un evento.
     *
     * @param event El evento a consumir.
     */
    void consumeEvent(Event event);

}
