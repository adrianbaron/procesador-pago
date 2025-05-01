package com.example.procesador_pago.domain.factory.impl.Notification;

import com.example.procesador_pago.domain.factory.INotification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WSNotification implements INotification {
    private String phoneNumber;
    private String message;
    private String mediaUrl;
    private String caption;
    private List<String> interactiveButtons = new ArrayList<>();
    private String language = "es"; // valor por defecto

    @Override
    public boolean send() {
        // Lógica para enviar el mensaje de WhatsApp
        System.out.println("Enviando mensaje de WhatsApp a: " + phoneNumber);
        System.out.println("Mensaje: " + message);

        if (mediaUrl != null && !mediaUrl.isEmpty()) {
            System.out.println("Media URL: " + mediaUrl);
            System.out.println("Leyenda: " + caption);
        }

        if (!interactiveButtons.isEmpty()) {
            System.out.println("Botones interactivos: " + interactiveButtons);
        }

        System.out.println("Idioma: " + language);

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