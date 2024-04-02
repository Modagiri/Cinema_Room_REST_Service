package cinema.exception;

public class SeatDoesNotExistException extends RuntimeException {
    private static final long serialVersionUID = 5071646428281007896L;

    public SeatDoesNotExistException(String message) {
        super(message);
    }
}
