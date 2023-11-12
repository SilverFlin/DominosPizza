package exceptions;

/**
 *
 */
public class MissingGamePresenterException extends IllegalStateException {

    public MissingGamePresenterException() {
    }

    public MissingGamePresenterException(String s) {
        super(s);
    }

    public MissingGamePresenterException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingGamePresenterException(Throwable cause) {
        super(cause);
    }

}
