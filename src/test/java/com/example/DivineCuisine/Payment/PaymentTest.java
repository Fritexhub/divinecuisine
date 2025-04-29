package com.example.DivineCuisine.Payment;
import com.example.DivineCuisine.dto.paymentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class PaymentTest {
    @Autowired
    private CreditCardPayment creditCardPayment;
    @Autowired
    private PayPalPayment payPalPayment;
    @Autowired
    private BankTransferPayment bankTransferPayment;
    @Test
    void testCreditCardPayment() {
        paymentDto request = new paymentDto();
        request.setAmount(50.0);
        request.setCardNumber("4111111111111111");

        String result = creditCardPayment.pay(request);
        assertEquals("Paid using Credit Card.", result);
    }
    @Test
    void testPayPalPayment() {
        paymentDto request = new paymentDto();
        request.setAmount(50.0);
        request.setPaypalEmail("user2@example.com");
        String result = payPalPayment.pay(request);
        assertEquals("Paid using PayPal with email: user2@example.com", result);
    }
        @Test
        void testBankTransferPayment() {
            paymentDto request = new paymentDto();
            request.setAmount(50.0);
            request.setAccountNumber("1234567890");
            String result = bankTransferPayment.pay(request);
            assertEquals("Paid via Bank Transfer to account: 1234567890", result);
        }
    @Test
    void testNoPaymentStrategyThrowsExceptionWithMessage() {
        PaymentContext context = new PaymentContext();
        paymentDto request = new paymentDto();
        request.setAmount(50.0);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> context.pay(request));
        assertEquals("Payment strategy is not set", exception.getMessage());
    }
}

