package com.bruno.bff_agendadortarefas.infrastructure.exceptions;

public class FeignErrorException extends RuntimeException {

    public FeignErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}