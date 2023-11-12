package network;

import edu.itson.eventschema.Event;

/**
 * Interfaz que define un consumidor de eventos.
 */
public interface EventConsumer {

    /**
     * Consume un evento.
     *
     * @param event El evento que se va a consumir.
     */
    void consumeEvent(Event event);

}
