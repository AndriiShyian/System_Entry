package exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DAOException extends RuntimeException {




    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
