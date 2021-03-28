package dhu.carnet.domain;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
class CarnetException extends Exception {

    public CarnetException() {
    }

    public CarnetException(String message) {
        super(message);
    }

    public CarnetException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarnetException(Throwable cause) {
        super(cause);
    }

    public CarnetException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
