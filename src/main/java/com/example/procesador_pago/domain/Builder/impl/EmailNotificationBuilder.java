package com.example.procesador_pago.domain.Builder.impl;


import com.example.procesador_pago.domain.Builder.NotificationBuilder;
import com.example.procesador_pago.domain.factory.INotification;
import com.example.procesador_pago.domain.factory.impl.Notification.EmailNotification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailNotificationBuilder implements NotificationBuilder {

    private EmailNotification notification;

    public EmailNotificationBuilder() {
        reset();
    }
    @Override
    public void reset() {
        notification = new EmailNotification();
    }

    @Override
    public NotificationBuilder setRecipient(String recipient) {
        notification.setTo(recipient);
        return this;
    }

    @Override
    public NotificationBuilder setSubject(String subject) {
        notification.setSubject(subject);
        return this;
    }

    @Override
    public NotificationBuilder setMessage(String message) {
        notification.setBody(message);
        return this;
    }

    public EmailNotificationBuilder setCc(List<String> cc) {
        notification.setCc(cc);
        return this;
    }

    public EmailNotificationBuilder setBcc(List<String> bcc) {
        notification.setBcc(bcc);
        return this;
    }
    public EmailNotificationBuilder setAttachments(List<String> attachments) {
        notification.setAttachments(attachments);
        return this;
    }

    public EmailNotificationBuilder setPriority(String priority) {
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
