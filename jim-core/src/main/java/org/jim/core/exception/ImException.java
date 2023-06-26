package org.jim.core.exception;

public class ImException extends Exception{

    public ImException(){

    }

    public ImException(String message){
        super(message);
    }

    public ImException(String message,Throwable cause){
        super(message, cause);
    }

    public ImException(Throwable cause){
        super(cause);
    }

    public ImException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
