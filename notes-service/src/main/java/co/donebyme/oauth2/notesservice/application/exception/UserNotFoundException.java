package co.donebyme.oauth2.notesservice.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aram Mkrtchyan.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "User not found.")
public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
