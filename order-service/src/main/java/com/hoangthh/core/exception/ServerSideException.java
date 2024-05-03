package com.hoangthh.core.exception;

public class ServerSideException extends RuntimeException {
    private String internalMessage;

    public ServerSideException(String message) {
        super(message);
        this.internalMessage = message;
    }

    public ServerSideException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerSideException(Throwable cause) {
        super(cause);
    }

    public ServerSideException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getInternalMessage() {
        return internalMessage;
    }
}
