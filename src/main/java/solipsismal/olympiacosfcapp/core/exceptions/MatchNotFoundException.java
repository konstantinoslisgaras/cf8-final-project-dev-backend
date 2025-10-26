package solipsismal.olympiacosfcapp.core.exceptions;

public class MatchNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "MatchNotFound";
    private static final String DEFAULT_MESSAGE = "The requested match was not found";

    public MatchNotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MESSAGE);
    }

    public MatchNotFoundException(String id) {
        super(DEFAULT_CODE, "Match: " + id + " was not found");
    }
}
