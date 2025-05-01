package com.example.DivineCuisine.Payment;


import com.example.DivineCuisine.dto.paymentDto;
import org.springframework.stereotype.Component;

@Component("bank")
public class BankTransferPayment implements PaymentStrategy {
    @Override
    public String pay(paymentDto request) {

        return "Paid via Bank Transfer to account: " + request.getAccountNumber();
    }
}

