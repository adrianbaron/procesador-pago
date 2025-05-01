package com.example.procesador_pago.domain.Builder;

import com.example.procesador_pago.domain.factory.INotification;

public interface NotificationBuilder {
    void reset();
    NotificationBuilder setRecipient(String recipient);
    NotificationBuilder setSubject(String subject);
    NotificationBuilder setMessage(String message);
    INotification build();
}
