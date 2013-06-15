package com.akavrt.csp.enumerator;

/**
 * <p>Order used in classical formulation of the 1D CSP with length and demand specified as
 * integers.</p>
 */
public class Order {
    private final int length;
    private final int quantity;

    public Order(int length, int quantity) {
        this.length = length;
        this.quantity = quantity;
    }

    public int getLength() {
        return length;
    }

    public int getQuantity() {
        return quantity;
    }
}
