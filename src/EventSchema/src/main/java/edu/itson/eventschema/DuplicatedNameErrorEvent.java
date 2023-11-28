package edu.itson.eventschema;

/**
 * Clase que representa un evento de error por nombre duplicado en el sistema.
 * Este evento contiene un resumen del error que incluye un mensaje descriptivo.
 */
public class DuplicatedNameErrorEvent extends Event<ErrorSummary> {

    /**
     * Constructor de la clase DuplicatedNameErrorEvent.
     *
     * @param payload Objeto ErrorSummary que contiene el mensaje descriptivo
     * del error.
     */
    public DuplicatedNameErrorEvent(final ErrorSummary payload) {
        super(payload);
        this.type = EventType.ERROR;
    }

}
