package edu.itson.eventschema;

/**
 * Clase que representa un resumen de un error en el sistema. Contiene un
 * mensaje descriptivo del error.
 */
public class ErrorSummary {

    /**
     * Mensaje descriptivo del error.
     */
    private String message;

    /**
     * Constructor de la clase ErrorSummary.
     *
     * @param message Mensaje descriptivo del error.
     */
    public ErrorSummary(final String message) {
        this.message = message;
    }

    /**
     * Obtiene el mensaje descriptivo del error.
     *
     * @return Mensaje descriptivo del error.
     */
    public String getMessage() {
        return message;
    }

}
