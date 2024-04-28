package ar.edu.utn.frbb.tup.persistence.exception;

public class DaoException extends RuntimeException {

    public DaoException(String message) {
        super(message);
    }
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}