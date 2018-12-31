package pub.starfish.util.reflect.exception;

public class BaseReflectException extends Exception{
    private ErrorEnum error;
    public BaseReflectException(ErrorEnum error) {
        super(error.code+":"+error.message);
        this.error=error;
    }

    public BaseReflectException(ErrorEnum error, Throwable cause) {
        super(error.code+":"+error.message,cause);
        this.error=error;
    }

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }

    public enum ErrorEnum{
        NO_SUCH_FIELD(100,"No such field"),
        NO_SUCH_SETTER(101,"No such setter"),
        NO_SUCH_GETTER(102,"No such getter"),
        ILLEGAL_ACCESS(103,"Illegal access class , field or method"),
        CATCH_ERROR(104,"method throw a exception");

        ErrorEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public final int code;
        public final String message;
    }
}
