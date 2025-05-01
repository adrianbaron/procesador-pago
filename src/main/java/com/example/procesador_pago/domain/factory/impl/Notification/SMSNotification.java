package com.example.procesador_pago.domain.factory.impl.Notification;

import com.example.procesador_pago.domain.factory.INotification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SMSNotification implements INotification {
    private String phoneNumber;
    private String message;
    private String senderId;
    private boolean deliveryReportRequired = false;
    private LocalDateTime scheduleTime;

    @Override
    public boolean send() {
        // Lógica para enviar el SMS
        System.out.println("Enviando SMS a: " + phoneNumber);
        System.out.println("Mensaje: " + message);
        System.out.println("Remitente: " + senderId);
        System.out.println("Requiere confirmación: " + deliveryReportRequired);

        if (scheduleTime != null) {
            System.out.println("Programado para: " + scheduleTime);
        }

        // Implementación real del envío
        return true;
    }

    // Getters y setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public boolean isDeliveryReportRequired() {
        return deliveryReportRequired;
    }

    public void setDeliveryReportRequired(boolean deliveryReportRequired) {
        this.deliveryReportRequired = deliveryReportRequired;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}
