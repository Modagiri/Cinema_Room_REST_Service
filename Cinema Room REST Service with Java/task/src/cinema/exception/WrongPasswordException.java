package cinema.exception;

public class WrongPasswordException extends RuntimeException {
    private static final long serialVersionUID = 5071646428281007896L;

    public WrongPasswordException(String message) {
        super(message);
    }
}
