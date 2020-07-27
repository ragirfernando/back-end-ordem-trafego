package com.ordemtrafego.exceptions;

public class DatabaseException extends RuntimeException{
    private static final long serialVerionUID = 1L;

    public DatabaseException(String mensagem){
        super(mensagem);
    }

}
