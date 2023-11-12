package network;

import edu.itson.eventschema.Event;

/**
 * Interfaz que define un sujeto de eventos.
 */
public interface EventSubject {

    /**
     * Agrega un observador al sujeto.
     *
     * @param observer El observador que se va a agregar.
     */
    void addObserver(EventConsumer observer);

    /**
     * Elimina un observador del sujeto.
     *
     * @param observer El observador que se va a eliminar.
     */
    void removeObserver(EventConsumer observer);

    /**
     * Notifica a todos los observadores sobre un evento.
     *
     * @param event El evento que se va a notificar a los observadores.
     */
    void notifyObservers(Event event);
}
