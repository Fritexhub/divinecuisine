package com.example.DivineCuisine.controller;

import com.example.DivineCuisine.dto.paymentDto;
import com.example.DivineCuisine.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String showPaymentForm(Model model) {
        model.addAttribute("paymentDto", new paymentDto());
        return "payment";
    }
    @PostMapping("/process")
    public String processPayment(@ModelAttribute paymentDto paymentDto, Model model) {
        String result = paymentService.processPayment(paymentDto);
        model.addAttribute("message", result);
        return "payment-success";
    }

}
