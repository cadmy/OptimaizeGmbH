package ru.cadmy.optimaizegmbh.exception;

/**
 * Created by Cadmy on 17.03.2020.
 */
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
