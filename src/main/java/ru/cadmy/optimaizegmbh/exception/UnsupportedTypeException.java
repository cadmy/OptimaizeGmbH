package ru.cadmy.optimaizegmbh.exception;

/**
 * Created by Cadmy on 18.03.2020.
 */
public class UnsupportedTypeException extends Exception {

    public UnsupportedTypeException(String message) {
        super(message);
    }

    public UnsupportedTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}