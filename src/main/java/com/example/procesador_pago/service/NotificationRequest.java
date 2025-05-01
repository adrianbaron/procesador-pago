package com.example.procesador_pago.service;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationRequest {
    // Atributos comunes básicos
    private String type;
    private String recipient;
    private String subject;
    private String message;

    // Email específicos
    private List<String> cc;
    private List<String> bcc;
    private List<String> attachments;
    private String emailPriority;

    // SMS específicos
    private String senderId;
    private Boolean deliveryReportRequired;
    private LocalDateTime scheduleTime;

    // Push específicos
    private String imageUrl;
    private String clickAction;
    private String pushPriority;

    // WhatsApp específicos
    private String mediaUrl;
    private String caption;
    private List<String> interactiveButtons;
    private String language;

    // Constructor vacío necesario para deserialización
    public NotificationRequest() {
    }

    // Getters y setters
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getEmailPriority() {
        return emailPriority;
    }

    public void setEmailPriority(String emailPriority) {
        this.emailPriority = emailPriority;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Boolean getDeliveryReportRequired() {
        return deliveryReportRequired;
    }

    public void setDeliveryReportRequired(Boolean deliveryReportRequired) {
        this.deliveryReportRequired = deliveryReportRequired;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getClickAction() {
        return clickAction;
    }

    public void setClickAction(String clickAction) {
        this.clickAction = clickAction;
    }

    public String getPushPriority() {
        return pushPriority;
    }

    public void setPushPriority(String pushPriority) {
        this.pushPriority = pushPriority;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<String> getInteractiveButtons() {
        return interactiveButtons;
    }

    public void setInteractiveButtons(List<String> interactiveButtons) {
        this.interactiveButtons = interactiveButtons;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}