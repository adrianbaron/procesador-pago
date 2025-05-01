package com.example.procesador_pago.domain.factory.impl.Notification;

import com.example.procesador_pago.domain.factory.INotification;
import org.springframework.stereotype.Component;

@Component
public class PushNotification implements INotification {
    private String deviceToken;
    private String title;
    private String message;
    private String imageUrl;
    private String clickAction;
    private String priority = "normal"; // valor por defecto

    @Override
    public boolean send() {
        // Lógica para enviar la notificación push
        System.out.println("Enviando notificación push a: " + deviceToken);
        System.out.println("Título: " + title);
        System.out.println("Mensaje: " + message);

        if (imageUrl != null && !imageUrl.isEmpty()) {
            System.out.println("Imagen: " + imageUrl);
        }

        System.out.println("Acción: " + clickAction);
        System.out.println("Prioridad: " + priority);

        // Implementación real del envío
        return true;
    }

    // Getters y setters
    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}