package ru.hardy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@SpringBootApplication
public class StompServerApplication {



    public static void main(String[] args) {
        SpringApplication.run(StompServerApplication.class, args);

        
    }

}
