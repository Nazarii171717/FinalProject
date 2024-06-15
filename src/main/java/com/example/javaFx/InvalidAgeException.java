package com.example.javaFx;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
    }
    public InvalidAgeException() {
    }
    public String getMessage(String s) {
        return s;
    }
}
