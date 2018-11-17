package com.example.ws;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Slf4j
public class WsSampleHandler extends TextWebSocketHandler {

    public static final String LISTENING_URL = "/handler";
    private static final TextMessage PONG_MESSAGE = new TextMessage("pong");
    private static final String PING_MSG = "ping";

    @Override
    protected void handleTextMessage(final WebSocketSession session, final TextMessage message) throws IOException {
        final String payload = message.getPayload();
        if (StringUtils.equals(PING_MSG, payload)) {
            session.sendMessage(PONG_MESSAGE);
        }
    }

    @Override
    public void afterConnectionEstablished(final WebSocketSession session) {
        if (log.isDebugEnabled()) {
            log.debug("WebSocket connection established. Session id [{}].", session.getId());
        }
    }

    @Override
    public void afterConnectionClosed(final WebSocketSession session, final CloseStatus status) {
        if (log.isDebugEnabled()) {
            log.debug("WebSocket connection closed with status [{}]. Session id [{}].", status.toString(), session.getId());
        }
    }

}
