package com.example.spid.exceptions.customExceptions;

public class NoSpidsFoundException extends Exception {
    public NoSpidsFoundException(String msg) {
        super(msg);
    }

    public NoSpidsFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
