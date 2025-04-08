package com.example.procesador_pago.domain.impl.Notification;

import com.example.procesador_pago.domain.INotification;
import org.springframework.stereotype.Component;

@Component
public class PushNotification implements INotification {
    @Override
    public boolean send(String recipient, String subject, String message) {
        System.out.println("Enviando notificación push a: " + recipient);
        System.out.println("Título: " + subject);
        System.out.println("Contenido: " + message);
        // Implementación real para enviar push notification
        return true;
    }
}