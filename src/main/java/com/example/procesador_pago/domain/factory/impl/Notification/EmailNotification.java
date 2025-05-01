package com.example.procesador_pago.domain.factory.impl.Notification;

import com.example.procesador_pago.domain.factory.INotification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailNotification implements INotification {
    private String to;
    private String subject;
    private String body;
    private List<String> cc = new ArrayList<>();
    private List<String> bcc = new ArrayList<>();
    private List<String> attachments = new ArrayList<>();
    private String priority = "media"; // valor por defecto

    @Override
    public boolean send() {
        // Lógica para enviar el correo electrónico
        System.out.println("Enviando correo electrónico a: " + to);
        System.out.println("Asunto: " + subject);
        System.out.println("Contenido: " + body);
        System.out.println("CC: " + cc);
        System.out.println("BCC: " + bcc);
        System.out.println("Adjuntos: " + attachments);
        System.out.println("Prioridad: " + priority);

        // Implementación real del envío
        return true;
    }

    // Getters y setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}