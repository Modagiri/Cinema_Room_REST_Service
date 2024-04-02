package cinema.exception;


public class SeatNotVacantException extends RuntimeException {
    private static final long serialVersionUID = 5071646428281007896L;

    public SeatNotVacantException(String message) {
        super(message);
    }
}
