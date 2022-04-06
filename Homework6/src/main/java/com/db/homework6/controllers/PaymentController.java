package com.db.homework6.controllers;

import com.db.homework6.datalayer.DataBaseManager;
import com.db.homework6.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private DataBaseManager db;

    @PostMapping("/register")
    public void registerPayment(Payment payment) {
        db.register(payment);
        System.out.println("Payment registered");
    }
}
