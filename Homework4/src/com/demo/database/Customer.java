package com.demo.database;

public class Customer {
    private int id;
    private String username;
    private String last_name;
    private String first_name;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    public Customer(int id, String username,
                    String last_name, String first_name, String phone,
                    String address, String city, String postalCode,
                    String country) {
        this.id = id;
        this.username = username;
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
