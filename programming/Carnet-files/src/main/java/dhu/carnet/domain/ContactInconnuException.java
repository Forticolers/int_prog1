/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhu.carnet.domain;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class ContactInconnuException extends CarnetException {

    public ContactInconnuException() {
    }

    public ContactInconnuException(String message) {
        super(message);
    }

    public ContactInconnuException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactInconnuException(Throwable cause) {
        super(cause);
    }

    public ContactInconnuException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
