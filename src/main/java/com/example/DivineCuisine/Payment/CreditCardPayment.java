package com.example.DivineCuisine.Payment;


import com.example.DivineCuisine.dto.paymentDto;
import org.springframework.stereotype.Component;

@Component("credit")
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay(paymentDto request) {

        return "Paid using Credit Card.";
    }
}
