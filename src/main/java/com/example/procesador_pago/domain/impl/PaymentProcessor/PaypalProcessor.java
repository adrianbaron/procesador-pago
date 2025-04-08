package com.example.procesador_pago.domain.impl.PaymentProcessor;

import com.example.procesador_pago.domain.IPaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class PaypalProcessor implements IPaymentProcessor {
    private static final double COMMISSION_RATE = 0.02;
    private static final double ADDITIONAL_CHARGE_THRESHOLD = 750.0;
    private static final double ADDITIONAL_CHARGE = 7.0;

    @Override
    public double processPayment(double amount) {
        System.out.println("Procesando pago con PayPal");
        double finalAmount = amount + (amount * COMMISSION_RATE);

        if (amount > ADDITIONAL_CHARGE_THRESHOLD) {
            finalAmount += ADDITIONAL_CHARGE;
        }

        return finalAmount;
    }
}