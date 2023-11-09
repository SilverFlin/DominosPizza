package network;

import edu.itson.eventschema.Event;

/**
 *
 */
public interface EventSubject {

    void addObserver(EventConsumer observer);

    void removeObsever(EventConsumer observer);

    void notifyObservers(Event event);
}
