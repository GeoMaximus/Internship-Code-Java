package com.demo.database;

import java.sql.Date;

public class Order{
    private int id;
    private Date order_date;
    private Date shipped_date;
    private String status;
    private String comment;

    public Order(int id, Date order_date, Date shipped_date, String status, String comment) {
        this.id = id;
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.status = status;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public String getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", shipped_date=" + shipped_date +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
