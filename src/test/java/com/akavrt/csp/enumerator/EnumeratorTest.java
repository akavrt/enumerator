package com.akavrt.csp.enumerator;

import com.akavrt.csp.Order;
import com.akavrt.csp.Problem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Instances of the 1D SSSCSP used in tests obtained from:
 *
 * <ul>
 * <li>Pierce, J.F., 1964, Some Large-scale production scheduling problems in the paper industry
 * (Englewood Cliffs, NJ: Prentice Hall).</li>
 * <li>Diegel, A., et al., 1996, Setup minimising conditions in the trim loss problem. European Journal
 * of Operational Research, 95, 631-640.</li>
 * </ul>
 */
public class EnumeratorTest {

    /**
     * Test problem from Pierce (1964), pp. 16-17:
     * 3 effective from 12 feasible patterns expected.
     */
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

    /**
     * Test problem from Pierce (1964), pp. 16-17:
     * 3 effective from 8 feasible patterns expected.
     */
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

    /**
     * Test problem from Pierce (1964), p. 115:
     * 275 effective from 974 feasible patterns expected.
     */
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

    /**
     * Test problem from Diegel et al. (1996), p. 632:
     * 22 effective patterns expected.
     */
    @Test
    public void diegelProblem3() {
        Problem problem = new Problem(3600);

        problem.addOrder(new Order(700,  200));
        problem.addOrder(new Order(600,  100));
        problem.addOrder(new Order(500,  100));

        Enumerator enumerator = new Enumerator(problem);
        enumerator.enumerate();

        assertEquals(22, enumerator.getEffectivePatternsCount());
    }

    /**
     * Test problem from Diegel et al. (1996), p. 634:
     * 5827 effective patterns expected.
     */
    @Test
    public void diegelProblem8() {
        Problem problem = new Problem(5550);

        problem.addOrder(new Order(1000,  70));
        problem.addOrder(new Order( 835,  81));
        problem.addOrder(new Order( 720,  89));
        problem.addOrder(new Order( 660, 105));

        problem.addOrder(new Order( 640, 152));
        problem.addOrder(new Order( 570,  54));
        problem.addOrder(new Order( 440,  27));
        problem.addOrder(new Order( 420,  89));

        Enumerator enumerator = new Enumerator(problem);
        enumerator.enumerate();

        assertEquals(5827, enumerator.getEffectivePatternsCount());
    }


}
