package com.example.procesador_pago.domain.impl;

import com.example.procesador_pago.domain.IPaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class CreditCardProcessor implements IPaymentProcessor {
    private static final double COMMISSION_RATE = 0.03;
    private static final double ADDITIONAL_CHARGE_THRESHOLD = 1000.0;
    private static final double ADDITIONAL_CHARGE = 10.0;

    @Override
    public double processPayment(double amount) {
        System.out.println("Procesando pago con tarjeta de crédito");
        double finalAmount = amount + (amount * COMMISSION_RATE);

        if (amount > ADDITIONAL_CHARGE_THRESHOLD) {
            finalAmount += ADDITIONAL_CHARGE;
        }

        return finalAmount;
    }
}
