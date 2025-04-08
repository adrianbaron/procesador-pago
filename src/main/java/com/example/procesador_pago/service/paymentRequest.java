package com.example.procesador_pago.service;

public class paymentRequest {
    private String paymentType;
    private double amount;
    private String notificationType;
    private String notificationRecipient;

    public paymentRequest() {
    }

    public paymentRequest(String paymentType, double amount, String notificationType, String notificationRecipient) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.notificationType = notificationType;
        this.notificationRecipient = notificationRecipient;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationRecipient() {
        return notificationRecipient;
    }

    public void setNotificationRecipient(String notificationRecipient) {
        this.notificationRecipient = notificationRecipient;
    }
}