package solipsismal.olympiacosfcapp.core.exceptions;

public class PlayerNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "PlayerNotFound";
    private static final String DEFAULT_MESSAGE = "The requested player was not found";

    public PlayerNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public PlayerNotFoundException(String lastname) {
        super(DEFAULT_CODE, "Player with lastname: '" + lastname + "' was not found");
    }
}