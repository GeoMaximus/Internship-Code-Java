package com.db.urlshortener.service;

import com.db.urlshortener.models.UrlEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlConverter {
    public static final String urlString = "abcdefghiklmnoprstuvwxyzABCDEFGHIKLMNOPUVWXYZ0123456789";
    private char[] urlCharacters = urlString.toCharArray();
    private int base = urlCharacters.length;

    public String getShortUrl(String originalUrl){

    }

    public String retrieve(String originalUrl) {
        String shortUrl = getShortUrl(originalUrl);
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setOriginalUrl(originalUrl);
        urlEntity.setShortUrl(shortUrl);
        return shortUrl;
    }

    public String encode(long num) {
        String base="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String result="";
        int cnt=6;
        while(num!=0 && cnt>0)
        {
            long r=num % 62;
            result+=base.charAt((int)r);
            num=num/62;
            cnt--;
        }
        return result;
    }

    public String decode(String input) {
        var characteres = input.toCharArray();
        var length = characteres.length;
        var decoded = "";

        var counter = 1;
        for(int i = 0; i< length; i++) {
            decoded += urlString.indexOf((int) (characteres[i] * Math.pow(base, length - counter)));
            counter++;
        }
        return decoded;
    }
}
