package ro.tuc.ds2020.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //PREFIXUL SOCKET-ULUI DESCHIS INTRE FRONTEND SI BACKEND PENTRU NOTIFICARE SI CHAT:
        registry.enableSimpleBroker("/energyConsumptionSimulation", "/chat", "/chatNotifications");
        //registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // SETAM UN ENDPOINT PENTRU WEBSOCKET-UL PARTII DE BACKEND:
        registry.addEndpoint("/notificationServer").setAllowedOrigins("*").withSockJS();

        // PENTRU CHAT:
        registry.addEndpoint("/chatServer").setAllowedOrigins("*").withSockJS();

        // PENTRU NOTIFICARILE CHAT-ULUI:
        registry.addEndpoint("/chatNotificationsServer").setAllowedOrigins("*").withSockJS();
    }
}
