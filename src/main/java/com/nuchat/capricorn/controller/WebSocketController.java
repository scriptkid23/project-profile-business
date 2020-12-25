package com.nuchat.capricorn.controller;

import com.nuchat.capricorn.dto.MessageWebSocketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/send/message")
    public void sendMessage(String message){
        System.out.println(message);
        messagingTemplate.convertAndSend("/message",  message);

    }

    // when logged into the system, users will subscribe to their contact list
    // they will subscribe / contact /: id with id as their id
    // whatever the sender conversation they will receive will be
//    @MessageMapping("/contact/:id")
//    public void handleSubscribeContact(@Payload MessageWebSocketDTO messageWebSocketDTO) throws Exception{
//        messagingTemplate.convertAndSendToUser(
//                messageWebSocketDTO.getContactid(),
//                "/queue/contacts",
//                messageWebSocketDTO
//        );
//    }

    @MessageMapping("/queue/workspace")
    public void handleSubscribeWorkspace(@Payload MessageWebSocketDTO messageWebSocketDTO) throws Exception{
        messagingTemplate.convertAndSend(
                "/workspace",
                messageWebSocketDTO
        );
    }



}
