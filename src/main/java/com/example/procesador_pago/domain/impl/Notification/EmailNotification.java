package com.example.procesador_pago.domain.impl.Notification;

import com.example.procesador_pago.domain.INotification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements INotification {
    @Override
    public boolean send(String recipient, String subject, String message) {
        System.out.println("Enviando notificación por correo electrónico a: " + recipient);
        System.out.println("Asunto: " + subject);
        System.out.println("Mensaje: " + message);
        // Implementación real para enviar email
        return true;
    }
}