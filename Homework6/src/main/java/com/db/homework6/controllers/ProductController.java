package com.db.homework6.controllers;

import com.db.homework6.datalayer.DataBaseManager;
import com.db.homework6.model.Product;
import com.db.homework6.model.ProductOrderPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    DataBaseManager db;

    @GetMapping("/get")
    public ResponseEntity<?> getProducts() {
        List<Product> productList = db.getProducts();
        ResponseEntity<?> response =new ResponseEntity<>(productList, HttpStatus.OK);
        return response;

    }

    @GetMapping("/get/{code}")
    public ResponseEntity<?> getProductByCode(@PathVariable String code) {
        Product product = db.getProductByCode(code);
        ResponseEntity<?> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        db.insertProduct(product);
        System.out.println("Product add to the database");
    }

    @PutMapping("/update/{code}")
    public void updateProduct(@PathVariable String code, @RequestBody String name){
        db.updateProductName(code, name);
        System.out.println("Updated product name with code: " + code);
    }

    @DeleteMapping("/delete/{code}")
    public void deleteProduct(@PathVariable String code){
        db.deleteProduct(code);
        System.out.println("Product with code: " + code + " has been deleted");
    }

    @GetMapping("/getProductsWithOrders")
    public ResponseEntity<?> getProductsWithOrders() {
        List<ProductOrderPair> productOrderPair = db.getProductsWithOrders();
        ResponseEntity<?> response = new ResponseEntity<>(productOrderPair, HttpStatus.OK);
        return response;
    }
}
