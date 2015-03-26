package codacy.api.error;

public class CodacyGenericException extends Exception {

    public CodacyGenericException(String message) {
        super(message);
    }

    public CodacyGenericException(Throwable cause) {
        super(cause);
    }
}
