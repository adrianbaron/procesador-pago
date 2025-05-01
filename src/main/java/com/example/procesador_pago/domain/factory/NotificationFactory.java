package com.example.procesador_pago.domain.factory;

import com.example.procesador_pago.domain.Builder.NotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.EmailNotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.PushNotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.SMSNotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.WhatsAppNotificationBuilder;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotificationFactory {

    private final Map<String, NotificationBuilder> notificationBuilders = new HashMap<>();

    @Autowired
    public NotificationFactory(
            EmailNotificationBuilder emailBuilder,
            PushNotificationBuilder pushBuilder,
            SMSNotificationBuilder smsBuilder,
            WhatsAppNotificationBuilder wsBuilder) {

        notificationBuilders.put("email", emailBuilder);
        notificationBuilders.put("push", pushBuilder);
        notificationBuilders.put("sms", smsBuilder);
        notificationBuilders.put("ws", wsBuilder);
    }

    public NotificationBuilder getBuilder(String type) {
        NotificationBuilder builder = notificationBuilders.get(type.toLowerCase());
        if (builder == null) {
            throw new IllegalArgumentException("Tipo de notificación no soportado: " + type);
        }
        return builder;
    }
}
