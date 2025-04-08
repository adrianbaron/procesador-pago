package com.example.procesador_pago.service;

public class NotificationResponse {
    private boolean success;
    private String type;
    private String recipient;
    private String message;

    public NotificationResponse() {
    }

    public NotificationResponse(boolean success, String type, String recipient, String message) {
        this.success = success;
        this.type = type;
        this.recipient = recipient;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}