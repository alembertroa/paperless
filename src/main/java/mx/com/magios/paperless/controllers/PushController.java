package mx.com.magios.paperless.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/notifications")
@RestController
public class PushController{

    @PostMapping(
            value = "/sendPush",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendPushnotification(){



        return ResponseEntity
                       .noContent()
                       .build();

    }
}
