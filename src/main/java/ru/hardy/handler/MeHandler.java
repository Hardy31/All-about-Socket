package ru.hardy.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;
import ru.hardy.entity.LogLine;

import java.time.LocalDateTime;

@Slf4j
public class MeHandler implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Соединение установлено: {}", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

        String messagePayload = (String) message.getPayload();  //сообщение Полезная нагрузка
        log.info("Текст сообщения : {}", messagePayload);

        session.sendMessage(new TextMessage("Started processing messagePayload: " + session + " - " + messagePayload));
        Thread.sleep(1000);
        session.sendMessage(new TextMessage("Compileed processing messagePayload: "  + messagePayload));



        LogLine logLine1 = new LogLine(10,210, LocalDateTime.now(), 1);
        LogLine logLine2 = new LogLine(11,211, LocalDateTime.now(), 1);
        LogLine logLine3 = new LogLine(12,212, LocalDateTime.now(), 1);
        LogLine logLine4 = new LogLine(13,213, LocalDateTime.now(), 1);
        LogLine logLine5 = new LogLine(14,214, LocalDateTime.now(), 1);



        //Обрати внимание на .registerModule(new JavaTimeModule()); Без него LocalDataTime не будет конвертироваться в Jackson
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        String jsonLogLine1 = mapper.writeValueAsString(logLine1);
        String jsonLogLine2 = mapper.writeValueAsString(logLine2);
        String jsonLogLine3 = mapper.writeValueAsString(logLine3);
        String jsonLogLine4 = mapper.writeValueAsString(logLine4);
        String jsonLogLine5 = mapper.writeValueAsString(logLine5);

        session.sendMessage(new TextMessage(jsonLogLine1));
        Thread.sleep(1000);
        session.sendMessage(new TextMessage(jsonLogLine2));
        Thread.sleep(1000);
        session.sendMessage(new TextMessage(jsonLogLine3));
        Thread.sleep(1000);
        session.sendMessage(new TextMessage(jsonLogLine4));
        Thread.sleep(1000);
        session.sendMessage(new TextMessage(jsonLogLine5));
        Thread.sleep(1000);

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Exception occured:{} no session : {}", exception.getMessage(),session.getId());
        log.info("Произошло исключение:{} no session : {}", exception.getMessage(),session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Connection closed on session:{} with status : {}", session.getId(), closeStatus.getCode());
        log.info("Соединение закрыто on session:{} with status : {}", session.getId(), closeStatus.getCode());
    }

    @Override
    public boolean supportsPartialMessages() {
        log.info("supports Partial Messages ");
        log.info("Споддерживает частичные сообщения");
        return false;
    }
}
