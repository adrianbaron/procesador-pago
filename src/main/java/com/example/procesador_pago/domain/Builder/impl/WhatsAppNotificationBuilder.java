package com.example.procesador_pago.domain.Builder.impl;

import com.example.procesador_pago.domain.Builder.NotificationBuilder;
import com.example.procesador_pago.domain.factory.INotification;


import java.util.List;

import com.example.procesador_pago.domain.factory.impl.Notification.WSNotification;
import org.springframework.stereotype.Component;

@Component
public class WhatsAppNotificationBuilder implements NotificationBuilder {
    private WSNotification notification;

    public WhatsAppNotificationBuilder() {
        reset();
    }

    @Override
    public void reset() {
        notification = new WSNotification();
    }

    @Override
    public NotificationBuilder setRecipient(String recipient) {
        notification.setPhoneNumber(recipient);
        return this;
    }

    @Override
    public NotificationBuilder setSubject(String subject) {
        // WhatsApp no utiliza subject directamente
        return this;
    }

    @Override
    public NotificationBuilder setMessage(String message) {
        notification.setMessage(message);
        return this;
    }

    public WhatsAppNotificationBuilder setMediaUrl(String mediaUrl) {
        notification.setMediaUrl(mediaUrl);
        return this;
    }

    public WhatsAppNotificationBuilder setCaption(String caption) {
        notification.setCaption(caption);
        return this;
    }

    public WhatsAppNotificationBuilder setInteractiveButtons(List<String> buttons) {
        notification.setInteractiveButtons(buttons);
        return this;
    }

    public WhatsAppNotificationBuilder setLanguage(String language) {
        notification.setLanguage(language);
        return this;
    }

    @Override
    public INotification build() {
        INotification result = notification;
        reset();
        return result;
    }
}
