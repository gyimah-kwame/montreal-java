package io.turntabl;

public class ProductAlreadyRegisteredException extends Exception{

    private String message;

    public ProductAlreadyRegisteredException(String message) {
        super(message);
    }
}
