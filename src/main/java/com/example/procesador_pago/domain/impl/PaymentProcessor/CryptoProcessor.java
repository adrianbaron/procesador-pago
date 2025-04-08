package com.example.procesador_pago.domain.impl.PaymentProcessor;

import com.example.procesador_pago.domain.IPaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class CryptoProcessor implements IPaymentProcessor {
    private static final double COMMISSION_RATE = 0.015; // 1.5%
    private static final double ADDITIONAL_CHARGE_THRESHOLD = 800.0;
    private static final double ADDITIONAL_CHARGE = 8.0;

    @Override
    public double processPayment(double amount) {
        System.out.println("Procesando pago con crypto");
        double finalAmount = amount * (1 - COMMISSION_RATE);
        if (amount > ADDITIONAL_CHARGE_THRESHOLD) {
            finalAmount -= ADDITIONAL_CHARGE;
        }
        return finalAmount;
    }
}
