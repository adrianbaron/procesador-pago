package com.example.procesador_pago.domain.factory;

import com.example.procesador_pago.domain.INotification;

import com.example.procesador_pago.domain.impl.Notification.EmailNotification;
import com.example.procesador_pago.domain.impl.Notification.PushNotification;
import com.example.procesador_pago.domain.impl.Notification.SMSNotification;
import com.example.procesador_pago.domain.impl.Notification.WSNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotificationFactory {

    private final Map<String, INotification> notifications = new HashMap<>();

    @Autowired
    public NotificationFactory(
            EmailNotification emailNotification,
            PushNotification pushNotification,
            SMSNotification smsNotification,
            WSNotification wsNotification) {

        notifications.put("email", emailNotification);
        notifications.put("push", pushNotification);
        notifications.put("sms", smsNotification);
        notifications.put("ws", wsNotification);
    }

    public INotification getNotification(String type) {
        INotification notification = notifications.get(type.toLowerCase());
        if (notification == null) {
            throw new IllegalArgumentException("Tipo de notificación no soportado: " + type);
        }
        return notification;
    }
}