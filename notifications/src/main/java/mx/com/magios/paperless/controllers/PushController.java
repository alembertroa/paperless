package mx.com.magios.paperless.controllers;

import mx.com.magios.paperless.beans.PushRequest;
import mx.com.magios.paperless.services.impl.NotificationServiceImpl;
import mx.com.magios.paperless.utils.PaperlessConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Controller to handle the notification operations</p>
 *
 * @author Cristian Alanis {@literal <snake404@gmail.com>}
 * @since 1.0.0
 */
@RequestMapping("/notifications")
@RestController
public class PushController{

    @Value("${twilio.fromWhats}")
    private String fromWhatsapp;

    @Value("${twilio.fromSMS}")
    private String fromSMS;

    @Autowired
    private NotificationServiceImpl notificationService;

    /**
     * <p>Send the SMS notification</p>
     *
     * @param request The request with the desired message and destination
     *
     * @return A 204 http status if success
     */
    @PostMapping(
            value = "/sendWhats",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendPushnotification(@RequestBody PushRequest request){

        String to = PaperlessConstants.WHATSAPP + request.getTo();
        notificationService.sendNotification(to, fromWhatsapp, request.getMessage());

        return ResponseEntity
                       .noContent()
                       .build();
    }

    /**
     * <p>Send the SMS notification</p>
     *
     * @param request The request with the desired message and destination
     *
     * @return A 204 http status if success
     */
    @PostMapping(
            value = "/sendSMS",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity sendSMSNotification(@RequestBody PushRequest request){

        notificationService.sendNotification(request.getTo(), fromSMS, request.getMessage());

        return ResponseEntity
                       .noContent()
                       .build();
    }
}
