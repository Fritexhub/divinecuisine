package com.example.DivineCuisine.Payment;

import com.example.DivineCuisine.dto.paymentDto;
import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPalPayment implements PaymentStrategy {
    @Override
    public String pay(paymentDto request) {

        return "Paid using PayPal with email: " + request.getPaypalEmail();
    }
}
