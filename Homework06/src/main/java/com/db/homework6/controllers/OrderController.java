package com.db.homework6.controllers;

import com.db.homework6.datalayer.DataBaseManager;
import com.db.homework6.exceptions.OrderException;
import com.db.homework6.models.Order;
import com.db.homework6.models.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    DataBaseManager db;

    @PutMapping("/place/{id}")
    public void placeOrder(@PathVariable("id") Integer orderId, @RequestBody OrderDetails orderDetails) throws OrderException {
        if (db.isIdAvailable(orderId)) {
            db.placeOrder(orderId, orderDetails);
        } else {
            throw new OrderException("Invalid order id");
        }
    }

    @PutMapping("/placeOrder")
    public void placeOrder(@RequestBody Order order, @RequestBody OrderDetails orderDetails) throws OrderException {
        if (!db.isIdAvailable(order.getId())) {
            db.placeOrder(order, orderDetails);
        } else {
            throw new OrderException("The order you're trying to add already exists");
        }
    }

}
