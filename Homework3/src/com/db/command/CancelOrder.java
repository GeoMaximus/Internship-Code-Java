package com.db.command;

public class CancelOrder implements Command{
    Order order;

    public CancelOrder(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancelOrder();
    }
}
