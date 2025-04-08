package com.example.procesador_pago.domain;

public interface INotification {
    boolean send(String recipient, String subject, String message);
}
