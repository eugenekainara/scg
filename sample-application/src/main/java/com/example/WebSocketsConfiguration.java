package com.example;

import com.example.ws.WsSampleHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.ExceptionWebSocketHandlerDecorator;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import static com.example.ws.WsSampleHandler.LISTENING_URL;


@Configuration
@EnableWebSocket
@AllArgsConstructor
public class WebSocketsConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(@NonNull final WebSocketHandlerRegistry registry) {
        registry.addHandler(handler(), LISTENING_URL)
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler handler() {
        final WsSampleHandler wsSampleHandler = new WsSampleHandler();
        return new ExceptionWebSocketHandlerDecorator(wsSampleHandler);
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        final long idleTimeout = 60_000L; //1min in ms
        final ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxSessionIdleTimeout(idleTimeout);
        return container;
    }

}
