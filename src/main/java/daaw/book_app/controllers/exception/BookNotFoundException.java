package daaw.book_app.controllers.exception;

public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public BookNotFoundException(final String message) {
        super(message);
    }

    public BookNotFoundException(final Throwable cause) {
        super(cause);
    }
}
