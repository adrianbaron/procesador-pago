package com.example.procesador_pago.controller;

import com.example.procesador_pago.domain.Builder.NotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.EmailNotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.PushNotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.SMSNotificationBuilder;
import com.example.procesador_pago.domain.Builder.impl.WhatsAppNotificationBuilder;
import com.example.procesador_pago.domain.factory.INotification;
import com.example.procesador_pago.domain.factory.NotificationFactory;
import com.example.procesador_pago.service.NotificationRequest;
import com.example.procesador_pago.service.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationFactory notificationFactory;

    @Autowired
    public NotificationController(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    @PostMapping("/send")
    public ResponseEntity<NotificationResponse> sendNotification(@RequestBody NotificationRequest request) {
        try {
            NotificationBuilder builder = notificationFactory.getBuilder(request.getType());

            // Configuración básica común para todas las notificaciones
            builder.setRecipient(request.getRecipient())
                    .setSubject(request.getSubject())
                    .setMessage(request.getMessage());

            // Configuración específica por tipo de notificación
            configureSpecificAttributes(builder, request);

            // Construir y enviar la notificación
            INotification notification = builder.build();
            boolean success = notification.send();

            NotificationResponse response = new NotificationResponse(
                    success,
                    request.getType(),
                    request.getRecipient(),
                    "Notificación enviada correctamente"
            );

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    new NotificationResponse(false, request.getType(), request.getRecipient(), e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                    new NotificationResponse(false, request.getType(), request.getRecipient(), "Error al enviar la notificación: " + e.getMessage())
            );
        }
    }

    private void configureSpecificAttributes(NotificationBuilder builder, NotificationRequest request) {
        // Configurar atributos específicos según el tipo de notificación
        switch(request.getType().toLowerCase()) {
            case "email":
                EmailNotificationBuilder emailBuilder = (EmailNotificationBuilder) builder;
                if (request.getCc() != null) {
                    emailBuilder.setCc(request.getCc());
                }
                if (request.getBcc() != null) {
                    emailBuilder.setBcc(request.getBcc());
                }
                if (request.getAttachments() != null) {
                    emailBuilder.setAttachments(request.getAttachments());
                }
                if (request.getEmailPriority() != null) {
                    emailBuilder.setPriority(request.getEmailPriority());
                }
                break;

            case "sms":
                SMSNotificationBuilder smsBuilder = (SMSNotificationBuilder) builder;
                if (request.getSenderId() != null) {
                    smsBuilder.setSenderId(request.getSenderId());
                }
                if (request.getDeliveryReportRequired() != null) {
                    smsBuilder.setDeliveryReportRequired(request.getDeliveryReportRequired());
                }
                if (request.getScheduleTime() != null) {
                    smsBuilder.setScheduleTime(request.getScheduleTime());
                }
                break;

            case "push":
                PushNotificationBuilder pushBuilder = (PushNotificationBuilder) builder;
                if (request.getImageUrl() != null) {
                    pushBuilder.setImageUrl(request.getImageUrl());
                }
                if (request.getClickAction() != null) {
                    pushBuilder.setClickAction(request.getClickAction());
                }
                if (request.getPushPriority() != null) {
                    pushBuilder.setPriority(request.getPushPriority());
                }
                break;

            case "ws":
                WhatsAppNotificationBuilder wsBuilder = (WhatsAppNotificationBuilder) builder;
                if (request.getMediaUrl() != null) {
                    wsBuilder.setMediaUrl(request.getMediaUrl());
                }
                if (request.getCaption() != null) {
                    wsBuilder.setCaption(request.getCaption());
                }
                if (request.getInteractiveButtons() != null) {
                    wsBuilder.setInteractiveButtons(request.getInteractiveButtons());
                }
                if (request.getLanguage() != null) {
                    wsBuilder.setLanguage(request.getLanguage());
                }
                break;

            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado: " + request.getType());
        }
    }
}