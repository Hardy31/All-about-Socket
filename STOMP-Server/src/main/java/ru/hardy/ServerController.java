package ru.hardy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ServerController {
//    @MessageMapping("/process-message")
    @MessageMapping("/process-message")
//    @SendTo("/topic/messages")
//    public OutgoingMessage processMessage(IncomingMessage incomingMessage) throws Exception{
//
//        System.out.println("Hello " + incomingMessage.getName());
//        return new OutgoingMessage("Hello " + incomingMessage.getName());
//    }


//    public String processMessage(IncomingMessage incomingMessage) throws Exception{
//        log.info(incomingMessage.toString());
//        System.out.println("Server Read " + incomingMessage.getName());
//        return "GGGGGGGGGGGGGGGGG";
//    }
    public String processMessage(String text) throws Exception{
//        log.info(incomingMessage.toString());
        System.out.println("Server Read " + text);
        return "GGGGGGGGGGGGGGGGG";
    }
}
