package mx.com.magios.paperless.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * <p>Bean to handle all the request of the project</p>
 *
 * @author Cristian Alanis {@literal <snake404@gmail.com>}
 * @since 1.0.0
 */
@Getter
@Setter
public class NotificationRequest{

    /**
     * <p>The destination of the notification</p>
     */
    private String to;

    /**
     * <p>The desired message that you want to send</p>
     */
    private String message;

}
