package com.db.urlshortener.controllers;

import com.db.urlshortener.datalayer.DatabaseManager;
import com.db.urlshortener.models.UrlEntity;
import com.db.urlshortener.service.UrlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class UrlController {
    @Autowired
    public DatabaseManager db;
    @Autowired
    public UrlConverter urlConverter;

    @PostMapping("/shorten")
    public void shortenUrl(@RequestBody UrlEntity urlEntity) {
        String url = urlEntity.getOriginalUrl();
        urlEntity.setShortUrl(urlConverter.encode(url));
        db.insert(urlEntity);
        System.out.println("Short url is: " + urlEntity.getShortUrl());
    }

    @GetMapping("/{url}")
    public ResponseEntity<?> redirect(@PathVariable String shortUrl){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("redirection", shortUrl);
        ResponseEntity<?> response = new ResponseEntity<>(httpHeaders, HttpStatus.PERMANENT_REDIRECT);
        return response;
    }


}
