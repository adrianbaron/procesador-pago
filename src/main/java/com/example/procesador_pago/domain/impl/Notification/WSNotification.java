package com.example.procesador_pago.domain.impl.Notification;

import com.example.procesador_pago.domain.INotification;
import org.springframework.stereotype.Component;

@Component
public class WSNotification implements INotification {
    @Override
    public boolean send(String recipient, String subject, String message) {
        System.out.println("Enviando notificación por Whatsapp a: " + recipient);
        System.out.println("Evento: " + subject);
        System.out.println("Datos: " + message);
        // Implementación real para enviar por WebSocket
        return true;
    }
}
