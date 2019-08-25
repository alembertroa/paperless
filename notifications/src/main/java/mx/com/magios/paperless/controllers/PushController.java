package mx.com.magios.paperless.controllers;

import mx.com.magios.paperless.beans.PushRequest;
import mx.com.magios.paperless.services.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/notifications")
@RestController
public class PushController{

    @Autowired
    private PushService pushService;

    @PostMapping(
            value = "/sendPush",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendPushnotification(@RequestBody PushRequest request){

        pushService.sendPushNotification(request);

        return ResponseEntity
                       .noContent()
                       .build();

    }
}
