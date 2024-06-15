package com.example.javaFx;

public class NotMatchingDataException extends Exception{
    public NotMatchingDataException(String message) {
        super(message);
    }
    public NotMatchingDataException() {
    }
    public String getMessage(String s) {
        return s;
    }
}
