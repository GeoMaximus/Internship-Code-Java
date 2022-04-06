package com.db.homework6.controllers;

import com.db.homework6.datalayer.DataBaseManager;
import com.db.homework6.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public DataBaseManager db;

    @GetMapping("/get/{id}")
    public ModelAndView getById(@PathVariable String id) {
        Customer customer = db.getCustomerById(id);
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }

    @DeleteMapping("/del/{id}")
    public ModelAndView deleteCustomer(@PathVariable String id) {
        Customer customer = db.getCustomerById(id);
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customer", customer);
        db.deleteCustomer(id);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAddCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("add-customer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addCustomer(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView("customer");
        db.insertCustomer(customer);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PutMapping("/update/{id}")
    public void updateCustomerPhone(@PathVariable String id, @RequestBody String phone) {
        db.updateCustomerPhone(id, phone);
        System.out.println("Customer with id: " + id + " has updated phone number");
    }

    @GetMapping("/get/byCity/{city}")
    public ModelAndView getCustomersByCity(@PathVariable String city) {
        ModelAndView modelAndView = new ModelAndView("customers-list");
        List<Customer> list = db.getCustomersByCity(city);
        modelAndView.addObject("customers",list);
        return modelAndView;
    }
}
