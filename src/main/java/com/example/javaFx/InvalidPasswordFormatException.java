package com.example.javaFx;

public class InvalidPasswordFormatException extends Exception{
    public InvalidPasswordFormatException(String message) {
        super(message);
    }
    public InvalidPasswordFormatException() {
    }
    public String getMessage(String s) {
        return s;
    }
}
