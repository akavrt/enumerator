package com.akavrt.csp.enumerator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: akavrt
 * Date: 15.06.13
 * Time: 23:42
 */
public class ProblemTest {

    @Test
    public void lengthsOrdering() {
        Problem problem = new Problem(100);
        problem.addOrder(new Order(10, 1));
        problem.addOrder(new Order(20, 2));
        problem.addOrder(new Order(15, 3));
        problem.addOrder(new Order(30, 4));
        problem.addOrder(new Order(25, 5));

        problem.prepare();

        // descending order of length is expected
        assertEquals(30, problem.getOrder(0).getLength());
        assertEquals(10, problem.getOrder(problem.size() - 1).getLength());
    }
}
