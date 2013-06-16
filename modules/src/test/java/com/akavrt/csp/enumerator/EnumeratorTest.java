package com.akavrt.csp.enumerator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: akavrt
 * Date: 16.06.13
 * Time: 01:47
 */
public class EnumeratorTest {

    @Test
    public void pierceProblem3_100() {
        Problem problem = new Problem(100);
        problem.addOrder(new Order(70, 2));
        problem.addOrder(new Order(60, 1));
        problem.addOrder(new Order(15, 9));

        Enumerator enumerator = new Enumerator(problem);
        enumerator.enumerate();

        assertEquals(12, enumerator.getFeasiblePatternsCount());
        assertEquals(3, enumerator.getEffectivePatternsCount());
    }

    @Test
    public void pierceProblem3_80() {
        Problem problem = new Problem(80);
        problem.addOrder(new Order(70, 2));
        problem.addOrder(new Order(60, 1));
        problem.addOrder(new Order(15, 9));

        Enumerator enumerator = new Enumerator(problem);
        enumerator.enumerate();

        assertEquals(8, enumerator.getFeasiblePatternsCount());
        assertEquals(3, enumerator.getEffectivePatternsCount());
    }

    @Test
    public void pierceProblem7() {
        Problem problem = new Problem(215);
        problem.addOrder(new Order(64, 782));
        problem.addOrder(new Order(60, 624));
        problem.addOrder(new Order(48, 142));
        problem.addOrder(new Order(45, 118));
        problem.addOrder(new Order(33, 144));
        problem.addOrder(new Order(32, 826));
        problem.addOrder(new Order(16, 188));

        Enumerator enumerator = new Enumerator(problem);
        enumerator.enumerate();

        assertEquals(974, enumerator.getFeasiblePatternsCount());
        assertEquals(275, enumerator.getEffectivePatternsCount());
    }

}
