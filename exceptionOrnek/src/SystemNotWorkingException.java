public class SystemNotWorkingException extends RuntimeException{
    public SystemNotWorkingException() {
    }

    public SystemNotWorkingException(String message) {
        super(message);
    }

    public SystemNotWorkingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemNotWorkingException(Throwable cause) {
        super(cause);
    }
}
