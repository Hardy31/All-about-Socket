package ru.hardy;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class SessionHandler extends StompSessionHandlerAdapter {

    //          Пока закомментировал, так как он не участвует изза отклюдения строки 47
    @Override
    public Type getPayloadType(StompHeaders headers) {
        return OutgoingMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received : " + ((OutgoingMessage) payload).getContent());
    }
}
