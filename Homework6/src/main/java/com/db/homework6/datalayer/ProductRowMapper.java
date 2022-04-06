package com.db.homework6.datalayer;

import com.db.homework6.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setCode(rs.getString("code"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setStock(rs.getInt("stock"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}
