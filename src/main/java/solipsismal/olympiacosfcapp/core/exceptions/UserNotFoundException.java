package solipsismal.olympiacosfcapp.core.exceptions;

public class UserNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "UserNotFound";
    private static final String DEFAULT_MESSAGE = "The requested user was not found";

    public UserNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String username) {
        super(DEFAULT_CODE, "User with username: '" + username + "' was not found");
    }

    public UserNotFoundException(Long id) {
        super(DEFAULT_CODE, "User with id: '" + id + "' was not found");
    }
}