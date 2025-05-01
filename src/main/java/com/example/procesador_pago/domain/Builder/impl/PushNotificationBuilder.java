package com.example.procesador_pago.domain.Builder.impl;

import com.example.procesador_pago.domain.Builder.NotificationBuilder;
import com.example.procesador_pago.domain.factory.INotification;


import com.example.procesador_pago.domain.factory.impl.Notification.PushNotification;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationBuilder implements NotificationBuilder {
    private PushNotification notification;

    public PushNotificationBuilder() {
        reset();
    }

    @Override
    public void reset() {
        notification = new PushNotification();
    }

    @Override
    public NotificationBuilder setRecipient(String recipient) {
        notification.setDeviceToken(recipient);
        return this;
    }

    @Override
    public NotificationBuilder setSubject(String subject) {
        notification.setTitle(subject);
        return this;
    }

    @Override
    public NotificationBuilder setMessage(String message) {
        notification.setMessage(message);
        return this;
    }

    public PushNotificationBuilder setImageUrl(String imageUrl) {
        notification.setImageUrl(imageUrl);
        return this;
    }

    public PushNotificationBuilder setClickAction(String clickAction) {
        notification.setClickAction(clickAction);
        return this;
    }

    public PushNotificationBuilder setPriority(String priority) {
        notification.setPriority(priority);
        return this;
    }

    @Override
    public INotification build() {
        INotification result = notification;
        reset();
        return result;
    }
}