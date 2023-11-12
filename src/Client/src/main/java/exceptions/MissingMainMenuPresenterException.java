package exceptions;

/**
 * Excepción lanzada cuando no se encuentra un MainMenuPresenter. Extiende de
 * IllegalStateException.
 */
public class MissingMainMenuPresenterException extends IllegalStateException {

    /**
     * Crea una nueva instancia de MissingMainMenuPresenterException sin un
     * mensaje detallado.
     */
    public MissingMainMenuPresenterException() {
    }

    /**
     * Crea una nueva instancia de MissingMainMenuPresenterException con un
     * mensaje detallado.
     *
     * @param s El mensaje detallado de la excepción.
     */
    public MissingMainMenuPresenterException(String s) {
        super(s);
    }

    /**
     * Crea una nueva instancia de MissingMainMenuPresenterException con un
     * mensaje y una causa.
     *
     * @param message El mensaje detallado de la excepción.
     * @param cause La causa de la excepción.
     */
    public MissingMainMenuPresenterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de MissingMainMenuPresenterException con una
     * causa.
     *
     * @param cause La causa de la excepción.
     */
    public MissingMainMenuPresenterException(Throwable cause) {
        super(cause);
    }

}
