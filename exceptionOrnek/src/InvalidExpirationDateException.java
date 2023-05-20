public class InvalidExpirationDateException extends RuntimeException{
    public InvalidExpirationDateException() {
    }

    public InvalidExpirationDateException(String message) {
        super(message);
    }

    public InvalidExpirationDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidExpirationDateException(Throwable cause) {
        super(cause);
    }
}
