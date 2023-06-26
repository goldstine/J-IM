package org.jim.core.exception;

public class ImDecodeException extends ImException{

    public ImDecodeException(String message){
        super(message);
    }

    public ImDecodeException(Throwable cause){
        super(cause);
    }
}
