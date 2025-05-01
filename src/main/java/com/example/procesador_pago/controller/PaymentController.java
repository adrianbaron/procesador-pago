package com.example.procesador_pago.controller;

import com.example.procesador_pago.domain.factory.INotification;
import com.example.procesador_pago.domain.factory.NotificationFactory;
import com.example.procesador_pago.domain.factory.PaymentProcessorFactory;
import com.example.procesador_pago.service.paymentRequest;
import com.example.procesador_pago.service.paymentResponse;
import com.example.procesador_pago.domain.factory.IPaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentProcessorFactory paymentProcessorFactory;
    private final NotificationFactory notificationFactory;

    @Autowired
    public PaymentController(
            PaymentProcessorFactory paymentProcessorFactory,
            NotificationFactory notificationFactory) {
        this.paymentProcessorFactory = paymentProcessorFactory;
        this.notificationFactory = notificationFactory;
    }

    @PostMapping("/process")
    public ResponseEntity<paymentResponse> processPayment(@RequestBody paymentRequest request) {
        try {
            IPaymentProcessor processor = paymentProcessorFactory.getProcessor(request.getPaymentType());
            double finalAmount = processor.processPayment(request.getAmount());

            paymentResponse response = new paymentResponse(
                    request.getAmount(),
                    finalAmount,
                    request.getPaymentType()
            );

            // Enviar notificación si se especifica en la solicitud
            if (request.getNotificationType() != null && !request.getNotificationType().isEmpty()) {
                try {
                    INotification notification = notificationFactory.getBuilder(request.getNotificationType()).build();
                    String subject = "Confirmación de pago";
                    String message = String.format("Su pago de %.2f mediante %s ha sido procesado. Monto final: %.2f",
                            request.getAmount(), request.getPaymentType(), finalAmount);

                    notification.send();
                    response.setNotificationSent(true);
                } catch (Exception e) {
                    // Capturamos la excepción pero no fallamos el proceso de pago
                    response.setNotificationSent(false);
                    response.setNotificationMessage("Error al enviar notificación: " + e.getMessage());
                }
            }

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}