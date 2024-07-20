package ru.hardy;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

public class ClientOne {
    private static final Logger log = LoggerFactory.getLogger(ClientOne.class);

    ClientOne(){
        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter()); //Замена конвертора
//        stompClient.setMessageConverter(new StringMessageConverter());

        ClientOneSessionHandler clientOneSessionHandler = new ClientOneSessionHandler();
        ListenableFuture<StompSession> sessionAsync =
//                stompClient.connect("wss://demo.piesocket.com/v3/channel_123?api_key=VCXCEuvhGcBDP7XhiJJUDvR1e1D3eiVjgZ9VRiaV&notify_self", clientOneSessionHandler);
                stompClient.connect("ws://localhost:8082/websocket-server", clientOneSessionHandler);
        StompSession session = null;
        try {
            session = sessionAsync.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        session.subscribe("/topic/messages", clientOneSessionHandler);


//
//        while (true) {
//            String text = " Client One Send /app/process-message - " + System.currentTimeMillis();
//            System.out.println(text );
////            session.send("/app/process-message", new IncomingMessage(text)); не работает,  что то с конвертаром
//            session.send("/app/process-message", new IncomingMessage(text));
//
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }



        }
    }
    class ClientOneSessionHandler extends StompSessionHandlerAdapter {

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

