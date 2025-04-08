package com.example.procesador_pago.controller;

import com.example.procesador_pago.domain.INotification;
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
            INotification notification = notificationFactory.getNotification(request.getType());
            boolean success = notification.send(
                    request.getRecipient(),
                    request.getSubject(),
                    request.getMessage()
            );

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
}