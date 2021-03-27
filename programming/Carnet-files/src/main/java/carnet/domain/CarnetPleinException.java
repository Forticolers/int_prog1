package carnet.domain;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class CarnetPleinException extends CarnetException {

    public CarnetPleinException() {
    }

    public CarnetPleinException(String message) {
        super(message);
    }

    public CarnetPleinException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarnetPleinException(Throwable cause) {
        super(cause);
    }

    public CarnetPleinException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

  
    
}
