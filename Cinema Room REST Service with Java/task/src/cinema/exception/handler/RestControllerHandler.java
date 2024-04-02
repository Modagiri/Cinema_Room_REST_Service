package cinema.exception.handler;

import cinema.exception.SeatDoesNotExistException;
import cinema.exception.SeatNotVacantException;
import cinema.exception.TokenExpiredException;
import cinema.exception.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerHandler extends ResponseEntityExceptionHandler {

    private class JsonResponse {
        private String error;

        public JsonResponse() {
        }

        public JsonResponse(String message) {
            this.error = message;
        }

        public String getError() {
            return error;
        }

        public void setMessage(String message) {
            this.error = message;
        }
    }

    @ExceptionHandler(value = {SeatNotVacantException.class})
    public ResponseEntity<JsonResponse> handleSeatNotVacant(SeatNotVacantException seatNotVacantException) {
        return new ResponseEntity<>(new JsonResponse(seatNotVacantException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {SeatDoesNotExistException.class})
    public ResponseEntity<JsonResponse> handleSeatDoesNotExistException(SeatDoesNotExistException seatDoesNotExistException) {
        return new ResponseEntity<>(new JsonResponse(seatDoesNotExistException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {TokenExpiredException.class})
    public ResponseEntity<JsonResponse> handleTokenExpiredException(TokenExpiredException tokenExpiredException) {
        return new ResponseEntity<>(new JsonResponse(tokenExpiredException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {WrongPasswordException.class})
    public ResponseEntity<JsonResponse> handleWrongPasswordException(WrongPasswordException wrongPasswordException) {
        return new ResponseEntity<>(new JsonResponse(wrongPasswordException.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
