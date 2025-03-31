package com.example.procesador_pago.domain;

public interface IPaymentProcessor {
    double processPayment(double amount);
}
