package com.example.procesador_pago.controller;

import com.example.procesador_pago.factory.PaymentProcessorFactory;
import com.example.procesador_pago.model.paymentRequest;
import com.example.procesador_pago.model.paymentResponse;
import com.example.procesador_pago.service.IPaymentProcessor;
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

    @Autowired
    public PaymentController(PaymentProcessorFactory paymentProcessorFactory) {
        this.paymentProcessorFactory = paymentProcessorFactory;
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

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}