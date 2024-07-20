package ru.hardy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Service
@Component
@Configurable
public class ScheduledPushMessages {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        String text = " SimpMessagingTemplate Send /topic/messages - " + System.currentTimeMillis();
        System.out.println(text );
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
        OutgoingMessage outgoingMessage = new OutgoingMessage(text);
        simpMessagingTemplate.convertAndSend("/topic/messages",
                outgoingMessage);
//        https://stackoverflow.com/questions/33004078/nullpointerexception-on-simpmessagingtemplate-in-spring
    }
}
