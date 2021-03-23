package me.wobblyyyy.achat.controller;

import me.wobblyyyy.achat.MessageAttributes;
import me.wobblyyyy.achat.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    @SuppressWarnings("ConstantConditions")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor accessor) {
//       accessor.getSessionAttributes().put(
//               MessageAttributes.USERNAME,
//               message.getSenderUsername()
//       );
       return message;
    }
}
