package com.db.homework6.datalayer;

import com.db.homework6.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DatabaseManager {
    JdbcTemplate template;

    @Autowired
    public DatabaseManager(DataSource dataSource) {
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
}
