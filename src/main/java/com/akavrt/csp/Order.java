package com.akavrt.csp;

/**
 * <p>Order definition used in classical 1D-CSP with length and demand specified as integers.</p>
 *
 * @author Victor Balabanov <akavrt@gmail.com>
 */
public class Order {
    private final long length;
    private final long demand;

    public Order(long length, long demand) {
        this.length = length;
        this.demand = demand;
    }

    public long getLength() {
        return length;
    }

    public long getDemand() {
        return demand;
    }
}
