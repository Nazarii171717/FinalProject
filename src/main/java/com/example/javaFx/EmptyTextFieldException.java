package com.example.javaFx;

public class EmptyTextFieldException extends Exception{
    public EmptyTextFieldException(String message) {super(message);}
    public EmptyTextFieldException() {}

    public String getMessage(String s) {
        return s;
    }

}
