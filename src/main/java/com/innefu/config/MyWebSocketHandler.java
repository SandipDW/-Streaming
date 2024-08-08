package com.innefu.config;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
    String clientMessage = message.getPayload();
    // Handle client message here (e.g., send a response back)
    String serverMessage = "Server received: " + clientMessage;
    session.sendMessage(new TextMessage(serverMessage));
    }
}
