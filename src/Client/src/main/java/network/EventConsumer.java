package network;

import edu.itson.eventschema.Event;

/**
 *
 */
public interface EventConsumer {

    void consumeEvent(Event event);

}
