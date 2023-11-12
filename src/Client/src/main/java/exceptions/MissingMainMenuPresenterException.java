package exceptions;

/**
 *
 */
public class MissingMainMenuPresenterException extends IllegalStateException {

    public MissingMainMenuPresenterException() {
    }

    public MissingMainMenuPresenterException(String s) {
        super(s);
    }

    public MissingMainMenuPresenterException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingMainMenuPresenterException(Throwable cause) {
        super(cause);
    }

}
