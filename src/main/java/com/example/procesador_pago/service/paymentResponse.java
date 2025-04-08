package com.example.procesador_pago.service;

public class paymentResponse {
    private double originalAmount;
    private double finalAmount;
    private String paymentType;
    private boolean notificationSent;
    private String notificationMessage;

    public paymentResponse() {
    }

    public paymentResponse(double originalAmount, double finalAmount, String paymentType) {
        this.originalAmount = originalAmount;
        this.finalAmount = finalAmount;
        this.paymentType = paymentType;
        this.notificationSent = false;
        this.notificationMessage = null;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isNotificationSent() {
        return notificationSent;
    }

    public void setNotificationSent(boolean notificationSent) {
        this.notificationSent = notificationSent;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }
}