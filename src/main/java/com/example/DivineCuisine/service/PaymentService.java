package com.example.DivineCuisine.service;

import com.example.DivineCuisine.Payment.PaymentStrategy;
import com.example.DivineCuisine.dto.paymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PaymentService {

    private final Map<String, PaymentStrategy> strategyMap;

    @Autowired
    public PaymentService(Map<String, PaymentStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public String processPayment(paymentDto request) {
        PaymentStrategy strategy = strategyMap.get(request.getMethod());
        if (strategy == null) {
            return "Unsupported payment method: " + request.getMethod();
        }
        return strategy.pay(request);
    }
}
