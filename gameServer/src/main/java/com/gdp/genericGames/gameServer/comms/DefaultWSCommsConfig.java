package com.gdp.genericGames.gameServer.comms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

/**
 * Spring Websocket manager.
 *
 * Created by fzelada on 24/02/2017.
 */

@Configuration
@EnableWebSocket
public class DefaultWSCommsConfig implements WebSocketConfigurer {
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(receiverHandler(),"/games").
				setAllowedOrigins("*");
				//.addInterceptors(new HttpSessionHandshakeInterceptor());//TODO: move string as resource, add interceptor to read headers
	}

	@Bean
	public WebSocketHandler receiverHandler() {
		return new PerConnectionWebSocketHandler(DefaultWSCommsManager.class);
	}
}
