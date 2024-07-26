package ru.hardy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Service
@Component
@Configurable
public class ScheduledPushMessages {
    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() throws JsonProcessingException {
        String text = " SimpMessagingTemplate Send /topic/messages - " + System.currentTimeMillis();
        System.out.println(text );
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
        LogLine logLine = new LogLine(200,300, LocalDateTime.now(), 4);
        String stringLogLine = objectMapper.writeValueAsString(logLine);

        OutgoingMessage outgoingMessage = new OutgoingMessage(stringLogLine);
        simpMessagingTemplate.convertAndSend("/topic/messages",
                outgoingMessage);
//        https://stackoverflow.com/questions/33004078/nullpointerexception-on-simpmessagingtemplate-in-spring
    }
}
