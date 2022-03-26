package com.db.command;

public class ExecuteOrder implements Command{
    Order order;
    public ExecuteOrder(Order o){
        this.order = o;
    }

    @Override
    public void execute() {
        order.placeOrder();
    }
}
