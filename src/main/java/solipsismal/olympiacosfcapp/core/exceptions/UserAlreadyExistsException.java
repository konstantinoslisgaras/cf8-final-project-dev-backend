package solipsismal.olympiacosfcapp.core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
@Getter
public class UserAlreadyExistsException extends RuntimeException {
    private static final String DEFAULT_CODE = "AlreadyExists";

    private final String errorCode;

    public UserAlreadyExistsException (String code, String message) {
        super(message);
        this.errorCode = code + DEFAULT_CODE;
    }

}
