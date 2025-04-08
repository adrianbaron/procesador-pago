package com.example.procesador_pago.domain.impl.Notification;

import com.example.procesador_pago.domain.INotification;
import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements INotification {
    @Override
    public boolean send(String recipient, String subject, String message) {
        System.out.println("Enviando SMS a: " + recipient);
        System.out.println("Mensaje: " + subject + " - " + message);
        // Implementación real para enviar SMS
        return true;
    }
}
