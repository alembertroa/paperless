package mx.com.magios.paperless.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PushService{

    @Value("${twilio.url}")
    private String twilioUrl;

    @Value("${twilio.from}")
    private String fromNumber;

    @Value("${twilio.authToken}")
    private String authToken;

    /**
     * <p></p>
     * @param request
     */
    public void sendPushNotification(Map<String, Object> request){

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);
        HttpHeaders headers = entity.getHeaders();
        headers.add("Authorization:",
                "Basic " + authToken);
        restTemplate.exchange(twilioUrl, HttpMethod.POST, entity, Map.class);
    }

}
