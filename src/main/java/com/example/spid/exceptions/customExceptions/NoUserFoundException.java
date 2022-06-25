package com.example.spid.exceptions.customExceptions;

public class NoUserFoundException extends Exception{

    public NoUserFoundException(String msg) {
        super(msg);
    }

    public NoUserFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
