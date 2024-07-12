package ru.hardy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@SpringBootApplication
public class StompClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StompClientApplication.class, args);


		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
		stompClient.setMessageConverter(new StringMessageConverter());
		String url = "ws://127.0.0.1:8080/endpoint";
		StompSessionHandler sessionHandler = new MyStompSessionHandler();
		stompClient.connect(url, sessionHandler);
		session.send("/topic/something", "payload");
	}

}
