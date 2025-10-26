package solipsismal.olympiacosfcapp.core.exceptions;

public class OpponentNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "OpponentNotFound";
    private static final String DEFAULT_MESSAGE = "The requested opponent was not found";

    public OpponentNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public OpponentNotFoundException(String opponent) {
        super(DEFAULT_CODE, "Team: " + opponent + " was not found");
    }
}
