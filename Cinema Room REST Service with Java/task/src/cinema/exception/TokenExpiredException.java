package cinema.exception;

public class TokenExpiredException extends RuntimeException {
    private static final long serialVersionUID = 5071646428281007896L;

    public TokenExpiredException(String message) {
        super(message);
    }
}
