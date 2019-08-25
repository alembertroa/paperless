package mx.com.magios.paperless.services.impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import mx.com.magios.paperless.services.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Value("${twilio.url}")
    private String twilioUrl;

    @Value("${twilio.account}")
    private String account;

    @Value("${twilio.authToken}")
    private String authToken;

    @PostConstruct
    public void init(){
        Twilio.init(account, authToken);
    }

    @Override
    public void sendNotification(String to, String fromNumber, String frontMessage){

        Message message = Message.creator(new PhoneNumber(to),
                new PhoneNumber(fromNumber), frontMessage).create();
        message.getAccountSid();
    }

}
