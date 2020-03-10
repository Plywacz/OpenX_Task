package plywacz.openx.exceptions;
/*
Author: BeGieU
Date: 10.03.2020
*/

public class UrlException extends RuntimeException {
    public UrlException(String message) {
        super(message);
    }

    public UrlException(String message, Throwable cause) {
        super(message, cause);
    }
}
