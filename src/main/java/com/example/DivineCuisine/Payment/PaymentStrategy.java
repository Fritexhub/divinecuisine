
package com.example.DivineCuisine.Payment;

import com.example.DivineCuisine.dto.paymentDto;

public interface PaymentStrategy {
    String pay(paymentDto request);
}
