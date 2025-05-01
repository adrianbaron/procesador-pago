package com.example.procesador_pago.domain.factory;

import com.example.procesador_pago.domain.factory.impl.PaymentProcessor.CreditCardProcessor;
import com.example.procesador_pago.domain.factory.impl.PaymentProcessor.CryptoProcessor;
import com.example.procesador_pago.domain.factory.impl.PaymentProcessor.DebitCardProcessor;
import com.example.procesador_pago.domain.factory.impl.PaymentProcessor.PaypalProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentProcessorFactory {
    private final Map<String, IPaymentProcessor> processors = new HashMap<>();

    @Autowired
    public PaymentProcessorFactory(CreditCardProcessor creditCardProcessor,
                                   DebitCardProcessor debitCardProcessor,
                                   PaypalProcessor payPalProcessor,
                                   CryptoProcessor cryptoProcessor) {
        processors.put("CREDIT_CARD", creditCardProcessor);
        processors.put("DEBIT_CARD", debitCardProcessor);
        processors.put("PAYPAL", payPalProcessor);
        processors.put("CRYPTO", cryptoProcessor);
    }

    public IPaymentProcessor getProcessor(String paymentType) {
        IPaymentProcessor processor = processors.get(paymentType);
        if (processor == null) {
            throw new IllegalArgumentException("Método de pago no soportado: " + paymentType);
        }
        return processor;
    }
}