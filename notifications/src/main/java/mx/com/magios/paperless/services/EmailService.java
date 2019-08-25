package mx.com.magios.paperless.services;

import mx.com.magios.paperless.exceptions.PaperlessException;

/**
 * <p>Interface with all the operations for the email services</p>
 * @author Cristian Alanis {@literal <snake404@gmail.com>}
 */
public interface EmailService{

    /**
     * <p>Send the email to the desired destination</p>
     * @param to The desired email destination
     * @param from The source email
     * @param message The body of the email
     * @throws PaperlessException If an error ocurr when sending the email
     */
    void sendEmail(String to, String from, String message) throws PaperlessException;
}
