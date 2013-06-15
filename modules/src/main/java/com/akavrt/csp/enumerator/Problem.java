package com.akavrt.csp.enumerator;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Defines 1D CSP with single stock size (length).</p>
 */
public class Problem {
    private final List<Order> orders;
    private final int stockLength;

    public Problem(List<Order> orders, int stockLength) {
        this.orders = new ArrayList<Order>();

        if (orders != null) {
            this.orders.addAll(orders);
        }

        this.stockLength = stockLength;
    }

    public Problem(int stockLength) {
        this(null, stockLength);
    }

    public int size() {
        return orders.size();
    }

    public Order getOrder(int index) {
        return index < orders.size() ? orders.get(index) : null;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order removeOrder(int index) {
        return index < orders.size() ? orders.remove(index) : null;
    }

    public int getStockLength() {
        return stockLength;
    }

}
