package com.db.observer;

public class Client implements Observer{

    @Override
    public void receiveNotification(String notification) {
        System.out.println("New notification" + notification);
    }
}
