package mx.com.magios.paperless.services;

/**
 * <p>Interface with all the operations relationated with the notifications</p>
 *
 * @author Cristian Alanis {@literal <snake404@gmail.com>}
 * @since 1.0.0
 */
public interface NotificationService{

    /**
     * <p>Send the request to twilio services</p>
     *
     * @param to The destination of the notification
     * @param fromNumber The source number
     * @param frontMessage The message to be send in the notification
     */
    void sendNotification(String to, String fromNumber, String frontMessage);
}
