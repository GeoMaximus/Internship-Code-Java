package com.db.urlshortener.datalayer;

import com.db.urlshortener.models.UrlEntity;
import com.db.urlshortener.service.UrlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DatabaseManager {
    JdbcTemplate template;
    UrlConverter urlConverter;
    @Autowired
    public DatabaseManager(DataSource dataSource) {this.template = new JdbcTemplate(dataSource);}

    public void insert(UrlEntity urlEntity){
        String query = "INSERT INTO url VALUES(?, ?)";
        urlEntity.setShortUrl("");
        template.update(query, urlEntity.getShortUrl(), urlEntity.getOriginalUrl());
    }








}
