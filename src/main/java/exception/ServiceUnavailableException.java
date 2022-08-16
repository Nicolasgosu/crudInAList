package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends RuntimeException {
    public ServiceUnavailableException(HttpStatus notFound, String book_not_found_){
        super();
    }

    public ServiceUnavailableException (String message, Throwable cause){
        super(message, cause);
    }

    public ServiceUnavailableException(String message){
        super(message);
    }

    public ServiceUnavailableException(Throwable cause) {
        super(cause);
    }
}
