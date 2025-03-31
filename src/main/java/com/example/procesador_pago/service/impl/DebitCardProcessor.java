package com.example.procesador_pago.service.impl;

import com.example.procesador_pago.service.IPaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class DebitCardProcessor implements IPaymentProcessor {
    private static final double COMMISSION_RATE = 0.01;
    private static final double ADDITIONAL_CHARGE_THRESHOLD = 500.0;
    private static final double ADDITIONAL_CHARGE = 5.0;

    @Override
    public double processPayment(double amount) {
        System.out.println("Procesando pago con tarjeta de débito");
        double finalAmount = amount + (amount * COMMISSION_RATE);

        if (amount < ADDITIONAL_CHARGE_THRESHOLD) {
            finalAmount += ADDITIONAL_CHARGE;
        }

        return finalAmount;
    }
}
