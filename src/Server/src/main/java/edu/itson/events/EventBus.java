package edu.itson.events;

import edu.itson.eventschema.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa un bus de eventos para la comunicación entre
 * componentes.
 */
public class EventBus {

    private final List<EventConsumer> consumers = new ArrayList<>();

    private static EventBus eventBus;

    private static final Logger LOG = Logger.getLogger(EventBus.class.getName());

    private EventBus() {
    }

    /**
     * Obtiene la instancia única del EventBus (patrón Singleton).
     *
     * @return La instancia del EventBus.
     */
    public static EventBus getInstance() {
        if (EventBus.eventBus == null) {
            EventBus.eventBus = new EventBus();
        }
        return EventBus.eventBus;
    }

    /**
     * Suscribe un consumidor al EventBus.
     *
     * @param consumer El consumidor a suscribir.
     */
    public void subscribe(final EventConsumer consumer) {
        this.consumers.add(consumer);
    }

    /**
     * Desuscribe un consumidor del EventBus.
     *
     * @param consumer El consumidor a desuscribir.
     */
    public void unsubscribe(final EventConsumer consumer) {
        this.consumers.remove(consumer);
    }

    /**
     * Envía un evento a todos los consumidores suscritos.
     *
     * @param event El evento a enviar.
     */
    public synchronized void sendEvent(final Event event) {
        LOG.log(Level.INFO, "Evento en bus: " + event + " notificando a " + this.consumers.size() + " clientes\n");
        // TODO quitar al emisor, agregar info en eventschema, IP/PORT
        for (EventConsumer consumer : consumers) {
            consumer.consumeEvent(event);
        }
    }

}
