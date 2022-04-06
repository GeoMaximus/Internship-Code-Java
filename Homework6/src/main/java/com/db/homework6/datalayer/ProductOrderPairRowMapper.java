package com.db.homework6.datalayer;

import com.db.homework6.model.ProductOrderPair;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductOrderPairRowMapper implements RowMapper<ProductOrderPair> {
    @Override
    public ProductOrderPair mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductOrderPair productOrderPair = new ProductOrderPair();
        productOrderPair.setOrder(rs.getString("orderdetails.id"));
        productOrderPair.setProduct(rs.getString("products.name"));
        return productOrderPair;
    }
}
