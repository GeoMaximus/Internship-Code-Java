package com.db.homework6.controllers;

import com.db.homework6.datalayer.DataBaseManager;
import com.db.homework6.model.Order;
import com.db.homework6.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    DataBaseManager db;

    @PutMapping("/place/{id}")
    public void placeOrder(@PathVariable("id") Integer orderId, @RequestBody OrderDetails orderDetails) throws Exception {
        if(orderId == orderDetails.getId()) {
            db.placeOrder(orderId, orderDetails);
        }
        else {
            throw new Exception();
        }
    }

    @PutMapping("/placeOrder")
    public void placeOrder(@RequestBody Order order, @RequestBody OrderDetails orderDetails) {
        db.placeOrder(order, orderDetails);
    }

}
