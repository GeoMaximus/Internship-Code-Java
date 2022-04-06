package com.db.homework6.datalayer;

import com.db.homework6.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DataBaseManager {
    JdbcTemplate template;

    @Autowired
    public DataBaseManager(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public Customer getCustomerById(String id) {
        String query = "SELECT * FROM customers WHERE id = ?";
        return template.queryForObject(query, new CustomerRowMapper(), id);
    }

    public void deleteCustomer(String id) {
        String query = "DELETE FROM customers WHERE id = ?";
        template.update(query, id);
    }

    public void insertCustomer(Customer customer) {
        String query = "INSERT INTO customers values(?,?,?,?,?,?,?,?,?)";
        template.update(query, customer.getId(), customer.getUsername(), customer.getLastName(), customer.getFirstName(),
                customer.getPhone(), customer.getAddress(), customer.getCity(), customer.getPostalCode(), customer.getCountry());
    }

    public List<Customer> getCustomersByCity(String city) {
        String query = "SELECT * FROM customers WHERE city = ? ";
        return template.query(query, new CustomerRowMapper(), city);
    }

    public void updateCustomerPhone(String id, String phone) {
        String query = "UPDATE customers SET phone = ? WHERE id = ?";
        template.update(query, phone, id);
    }

    public List<Product> getProducts() {
        String query = "SELECT * FROM products";
        return template.query(query, new ProductRowMapper());
    }

    public Product getProductByCode(String code) {
        String query = "SELECT * FROM products WHERE code = ?";
        return template.queryForObject(query, new ProductRowMapper(), code);
    }

    public List<ProductOrderPair> getProductsAndOrders() {

        return null;
    }

    public void insertProduct(Product product) {
        String query = "INSERT INTO products values(?,?,?,?,?)";
        template.update(query, product.getCode(), product.getName(), product.getDescription(), product.getStock(),
                product.getPrice());
    }

    public void updateProductName(String code, String name) {
        Product product = new Product();
        String query = "UPDATE products SET name = ? WHERE code = ?";
        template.update(query, name, code);
    }

    public void deleteProduct(String code) {
        String query = "DELETE FROM products WHERE code = ?";
        template.update(query, code);
    }

    public void register(Payment payment) {
        String query = "INSERT INTO payments VALUES(?, ?, ?)";
        template.update(query, payment.getCustomerId(), payment.getPaymentDate(), payment.getAmount());
    }

    public List<ProductOrderPair> getProductsWithOrders() {
        String query = "SELECT products.name, orderdetails.id from orderdetails JOIN products ON orderdetails.product_code = products.code";
        return template.query(query, new ProductOrderPairRowMapper());
    }

    public boolean isIdAvailable(int id) {
        String query = "SELECT COUNT(*) FROM orders WHERE id = ?";
        int count = template.queryForObject(query, new Object[]{id}, Integer.class);
        return count > 0;
    }

    public void updateStock() {
        String query = "UPDATE products, orderdetails SET stock = stock - quantity WHERE products.code = orderdetails.product_code";
        template.update(query);
    }

    public void placeOrder(int orderId, OrderDetails orderDetails) {
        String query = "INSERT INTO orderdetails VALUES(?,?,?,?)";
        template.update(query, orderId, orderDetails.getProduct_code(), orderDetails.getQuantity(), orderDetails.getPriceEach());
        updateStock();
    }

    public void placeOrder(Order order, OrderDetails orderDetails) {
        String query = "INSERT INTO orders VALUES(?,?,?,?,?,?)";
        template.update(query, order.getId(), order.getOrder_date(), order.getShipped_date(), order.getComments(), order.getCustomer_id());
        String query1 = "INSERT INTO orderdetails VALUES(?,?,?,?)";
        template.update(query1, orderDetails.getId(), orderDetails.getProduct_code(), orderDetails.getQuantity(), orderDetails.getPriceEach());
        updateStock();
    }

}
