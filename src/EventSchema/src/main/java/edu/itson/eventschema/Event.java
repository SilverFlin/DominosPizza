package edu.itson.eventschema;

import java.io.Serializable;

/**
 * Clase abstracta que representa un evento genérico.
 *
 * @param <T> Tipo de datos asociado al evento.
 */
public abstract class Event<T extends Serializable> implements Serializable {

    /**
     * Tipo de evento.
     */
    protected EventType type;

    /**
     * Datos asociados al evento.
     */
    protected T payload;

    /**
     * Dirección de quien envía el evento.
     */
    protected String senderAddress;

    /**
     * Constructor de la clase Event.
     *
     * @param payload Datos asociados al evento.
     */
    protected Event(final T payload) {
        this.payload = payload;
    }

    /**
     * Obtiene el tipo de evento.
     *
     * @return Tipo de evento.
     */
    public EventType getType() {
        return type;
    }

    /**
     * Obtiene los datos asociados al evento.
     *
     * @return Datos asociados al evento.
     */
    public T getPayload() {
        return payload;
    }

    /**
     * Obtiene la dirección del remitente del evento.
     *
     * @return Dirección del remitente del evento.
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * Establece la dirección del remitente del evento.
     *
     * @param senderAddress Dirección del remitente del evento.
     */
    public void setSenderAddress(final String senderAddress) {
        this.senderAddress = senderAddress;
    }
}
