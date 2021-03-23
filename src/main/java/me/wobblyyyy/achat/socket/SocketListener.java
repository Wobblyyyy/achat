package me.wobblyyyy.achat.socket;

import me.wobblyyyy.achat.MessageAttributes;
import me.wobblyyyy.achat.UserParser;
import me.wobblyyyy.achat.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Objects;

@Component
public class SocketListener {
    private static final Logger logger = LoggerFactory
            .getLogger(SocketListener.class);

    @Autowired
    private SimpMessageSendingOperations template;

    @EventListener
    public void handleSocketConnect(SessionConnectedEvent event) {

    }

    @EventListener
    public void handleSocketDisconnect(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor
                .wrap(event.getMessage());

        String username = (String) Objects.requireNonNull(accessor
                .getSessionAttributes()).get(MessageAttributes.USERNAME);

        String id = ((Integer) accessor
                .getSessionAttributes().get(MessageAttributes.ID)).toString();

        if (username != null) {
            logger.info("User disconnect: " + UserParser.parse(username, id));

            Message disconnectMessage = new Message() {{
                setType(MessageType.USER_LEAVE);
                setSenderUsername(username);
                setSenderId(id);
            }};

            template.convertAndSend(
                    "/topic/public",
                    disconnectMessage
            );
        }
    }
}
