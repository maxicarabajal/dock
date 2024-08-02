package com.tranqui.demo.excepciones;


public class ListEmptyException extends RuntimeException {

    public ListEmptyException(String message) {
        super(message);
    }
}
