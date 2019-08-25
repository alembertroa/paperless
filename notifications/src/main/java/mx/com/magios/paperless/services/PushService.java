package mx.com.magios.paperless.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import mx.com.magios.paperless.beans.PushRequest;
import mx.com.magios.paperless.converters.TwilioConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PushService{

    @Value("${twilio.url}")
    private String twilioUrl;

    @Value("${twilio.from}")
    private String fromNumber;

    @Value("${twilio.account}")
    private String account;

    @Value("${twilio.authToken}")
    private String authToken;

    @Autowired
    private TwilioConverter twilioConverter;

    @PostConstruct
    public void init(){
        Twilio.init(account, authToken);
    }

    /**
     * <p></p>
     * @param request
     */
    public void sendPushNotification(PushRequest request){

        Message message = Message.creator(new PhoneNumber("whatsapp:" + request.getTo()),
                new PhoneNumber(fromNumber), request.getMessage()).create();
        message.getAccountSid();
    }

}
