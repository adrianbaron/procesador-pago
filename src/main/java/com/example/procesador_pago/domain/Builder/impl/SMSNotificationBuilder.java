package com.example.procesador_pago.domain.Builder.impl;

import com.example.procesador_pago.domain.Builder.NotificationBuilder;
import com.example.procesador_pago.domain.factory.INotification;


import java.time.LocalDateTime;

import com.example.procesador_pago.domain.factory.impl.Notification.SMSNotification;
import org.springframework.stereotype.Component;

@Component
public class SMSNotificationBuilder implements NotificationBuilder {
    private SMSNotification notification;

    public SMSNotificationBuilder() {
        reset();
    }

    @Override
    public void reset() {
        notification = new SMSNotification();
    }

    @Override
    public NotificationBuilder setRecipient(String recipient) {
        notification.setPhoneNumber(recipient);
        return this;
    }

    @Override
    public NotificationBuilder setSubject(String subject) {
        // SMS no utiliza subject, podríamos ignorarlo o lanzar una excepción
        return this;
    }

    @Override
    public NotificationBuilder setMessage(String message) {
        notification.setMessage(message);
        return this;
    }

    public SMSNotificationBuilder setSenderId(String senderId) {
        notification.setSenderId(senderId);
        return this;
    }

    public SMSNotificationBuilder setDeliveryReportRequired(boolean required) {
        notification.setDeliveryReportRequired(required);
        return this;
    }

    public SMSNotificationBuilder setScheduleTime(LocalDateTime scheduleTime) {
        notification.setScheduleTime(scheduleTime);
        return this;
    }

    @Override
    public INotification build() {
        INotification result = notification;
        reset();
        return result;
    }
}