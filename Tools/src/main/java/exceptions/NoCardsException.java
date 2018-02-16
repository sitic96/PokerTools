package exceptions;

public class NoCardsException  extends Exception {
    public NoCardsException() {
        super();
    }

    public NoCardsException(String message) {
        super(message);
    }
}
