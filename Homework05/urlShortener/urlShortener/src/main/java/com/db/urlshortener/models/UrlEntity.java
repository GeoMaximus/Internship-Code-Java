package com.db.urlshortener.models;

public class UrlEntity {

    private String shortUrl;
    private String originalUrl;

    public UrlEntity() {}

    public UrlEntity(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public UrlEntity(String shortUrl, String originalUrl) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
        public String toString() {
            return "Url{" +
                    ", fullUrl='" + originalUrl + '\'' +
                    ", shortUrl='" + shortUrl + '\'' +
                    '}';
        }
    }

