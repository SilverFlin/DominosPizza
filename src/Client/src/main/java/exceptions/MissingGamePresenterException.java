package exceptions;

/**
 * Excepción lanzada cuando no se encuentra un GamePresenter. Extiende de
 * IllegalStateException.
 */
public class MissingGamePresenterException extends IllegalStateException {

    /**
     * Crea una nueva instancia de MissingGamePresenterException sin un mensaje
     * detallado.
     */
    public MissingGamePresenterException() {
    }

    /**
     * Crea una nueva instancia de MissingGamePresenterException con un mensaje
     * detallado.
     *
     * @param s El mensaje detallado de la excepción.
     */
    public MissingGamePresenterException(String s) {
        super(s);
    }

    /**
     * Crea una nueva instancia de MissingGamePresenterException con un mensaje
     * y una causa.
     *
     * @param message El mensaje detallado de la excepción.
     * @param cause La causa de la excepción.
     */
    public MissingGamePresenterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de MissingGamePresenterException con una causa.
     *
     * @param cause La causa de la excepción.
     */
    public MissingGamePresenterException(Throwable cause) {
        super(cause);
    }

}
