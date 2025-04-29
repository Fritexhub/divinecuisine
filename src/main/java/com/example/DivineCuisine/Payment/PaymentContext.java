package com.example.DivineCuisine.Payment;

import com.example.DivineCuisine.dto.paymentDto;
import org.springframework.stereotype.Component;

@Component
public class PaymentContext {

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public String pay(paymentDto request) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy is not set");
        }
        return strategy.pay(request);
    }
}
