package com.example.procesador_pago.model;

public class paymentResponse {
    private double originalAmount;
    private double finalAmount;
    private String paymentType;

    public paymentResponse() {
    }

    public paymentResponse(double originalAmount, double finalAmount, String paymentType) {
        this.originalAmount = originalAmount;
        this.finalAmount = finalAmount;
        this.paymentType = paymentType;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}