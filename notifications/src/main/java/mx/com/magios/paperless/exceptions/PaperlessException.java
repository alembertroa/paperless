package mx.com.magios.paperless.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Generic exception for this project</p>
 *
 * @author Cristian Alanis {@literal <snake404@gmail.com>}
 * @since 1.0.0
 */
public class PaperlessException extends Exception{

    @Getter
    @Setter
    private Integer errorCode;

    /**
     * <p>Just throw the exception with the message</p>
     * @param message The desired message
     */
    public PaperlessException(String message){
        super(message);
    }

    /**
     * <p>Set a message and error code in the exception</p>
     * @param message The desired message
     * @param errorCode The desired error code
     */
    public PaperlessException(String message, Integer errorCode){
        super(message);
        this.errorCode = errorCode;

    }

    /**
     * <p>Throw an exception if other exception in threw before</p>
     * @param message The desired message
     * @param errorCode The desired error code
     * @param e The catched exception
     */
    public PaperlessException(String message, Integer errorCode, Throwable e){
        super(message, e);
        this.errorCode = errorCode;
    }
}
