package codacy.api.error;

public class CommitNotFoundException extends Exception {

    public CommitNotFoundException(Throwable cause) {
        super(cause);
    }

}
