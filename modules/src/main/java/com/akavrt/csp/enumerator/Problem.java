package com.akavrt.csp.enumerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Defines 1D-CSP with single stock length.</p>
 *
 * @author Victor Balabanov <akavrt@gmail.com>
 */
public class Problem {
    private final List<Order> orders;
    private final long stockLength;

    public Problem(List<Order> orders, long stockLength) {
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

    public long getStockLength() {
        return stockLength;
    }

    /**
     * <p>Pierce's pattern generation/enumeration procedure requires that the
     * customers' orders have to be sorted in descending order of their lengths.</p>
     */
    public void prepare() {
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order lhs, Order rhs) {
                long lhsValue = lhs.getLength();
                long rhsValue = rhs.getLength();
                return lhsValue > rhsValue ? -1 : (lhsValue < rhsValue ? 1 : 0);
            }
        });
    }
}
