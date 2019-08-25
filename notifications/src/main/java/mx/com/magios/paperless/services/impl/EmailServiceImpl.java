package mx.com.magios.paperless.services.impl;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import mx.com.magios.paperless.exceptions.PaperlessException;
import mx.com.magios.paperless.services.EmailService;
import mx.com.magios.paperless.utils.PaperlessConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * <p>Implementation of the email services</p>
 *
 * @author Cristian Alanis {@literal <snake404@gmail.com>}
 * @since 1.0.0
 */
@Service
public class EmailServiceImpl implements EmailService{

    @Value("${email.key}")
    private String sendgridKey;

    private SendGrid sg;

    @PostConstruct
    public void init(){
        sg = new SendGrid(sendgridKey);
    }

    @Override
    public void sendEmail(String frontTo, String frontFrom, String message) throws PaperlessException{
        Email from = new Email(frontFrom);
        Email to = new Email(frontTo);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(from, PaperlessConstants.EMAIL_SUBJECT, to, content);
        Request request = new Request();

        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        }catch(IOException e){
            throw new PaperlessException("An error ocurrer while sending email", PaperlessConstants.TECHNICAL_ERROR, e);
        }
    }
}
