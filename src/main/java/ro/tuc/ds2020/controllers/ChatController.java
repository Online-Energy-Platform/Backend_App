package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ChatMessageDTO;

@RestController
@CrossOrigin
@RequestMapping(value = "/chat")
public class ChatController {

    private final SimpMessagingTemplate template;

    @Autowired
    public ChatController(SimpMessagingTemplate template){
        this.template = template;
    }

    @PostMapping()
    public ResponseEntity<ChatMessageDTO> sendMessageToUser(@RequestBody ChatMessageDTO message) {
        template.convertAndSend("/chat/message", message);
        System.err.println(message.getSenderID() + ", " + message.getSenderFullName() + ", " + message.getReceiverID()
                + ", " + message.getMessageBody());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/sendNotification")
    public ResponseEntity<ChatMessageDTO> sendNotificationToUser(@RequestBody ChatMessageDTO message){
        template.convertAndSend("/chatNotifications/message", message);
        System.err.println(message.getSenderID() + ", " + message.getSenderFullName() + ", " + message.getReceiverID()
                + ", " + message.getMessageBody());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
