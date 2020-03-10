package plywacz.openx.exceptions;
/*
Author: BeGieU
Date: 10.03.2020
*/

public class RemoteApiException  extends RuntimeException{
    public RemoteApiException(String message) {
        super(message);
    }

    public RemoteApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
