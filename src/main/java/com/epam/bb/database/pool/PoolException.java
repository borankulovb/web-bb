package com.epam.bb.database.pool;

public class PoolException extends RuntimeException{

    public PoolException() {
        super();
    }

    public PoolException(String message) {
        super(message);
    }

    public PoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoolException(Throwable cause) {
        super(cause);
    }

    public PoolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
