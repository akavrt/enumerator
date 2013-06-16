package com.akavrt.csp.enumerator;

/**
 * User: akavrt
 * Date: 16.06.13
 * Time: 02:27
 */
public class PierceSample {

    public static void main(String[] args) {
        Problem problem = new Problem(215000);

        problem.addOrder(new Order(159250,  80));
        problem.addOrder(new Order(144800, 117));
        problem.addOrder(new Order(127667,  50));
        problem.addOrder(new Order(103333,  66));
        problem.addOrder(new Order( 90017,  78));
        problem.addOrder(new Order( 69900, 111));
        problem.addOrder(new Order( 38000, 200));
        problem.addOrder(new Order( 27750,  57));

        problem.addOrder(new Order(156000,  46));
        problem.addOrder(new Order(140000, 184));
        problem.addOrder(new Order(125500, 104));
        problem.addOrder(new Order(100000,  90));
        problem.addOrder(new Order( 86000,  39));
        problem.addOrder(new Order( 64000,  57));
        problem.addOrder(new Order( 36667,  46));
        problem.addOrder(new Order( 22000, 180));

        problem.addOrder(new Order(152500, 138));
        problem.addOrder(new Order(133750, 208));
        problem.addOrder(new Order(121000,  77));
        problem.addOrder(new Order( 96000,  54));
        problem.addOrder(new Order( 83400, 143));
        problem.addOrder(new Order( 63500,  75));
        problem.addOrder(new Order( 35000, 150));
        problem.addOrder(new Order( 20100, 225));

        problem.addOrder(new Order(147000,  57));
        problem.addOrder(new Order(132000,  31));
        problem.addOrder(new Order(112500, 122));
        problem.addOrder(new Order( 95400, 103));
        problem.addOrder(new Order( 79850, 100));
        problem.addOrder(new Order( 59750,  90));
        problem.addOrder(new Order( 31060,  98));
        problem.addOrder(new Order( 18300,  75));

        problem.addOrder(new Order(146000,  29));
        problem.addOrder(new Order(129000,  95));
        problem.addOrder(new Order(108800, 133));
        problem.addOrder(new Order( 92200,  60));
        problem.addOrder(new Order( 71000, 305));
        problem.addOrder(new Order( 51000, 183));
        problem.addOrder(new Order( 28000,  65));
        problem.addOrder(new Order( 15000,  70));

        Enumerator enumerator = new Enumerator(problem);

        long start = System.currentTimeMillis();
        enumerator.enumerate();
        long end = System.currentTimeMillis();

        String result = String.format("Stock length is: %d" +
                                      "\n  %d effective from %d feasible patterns enumerated.",
                                      problem.getStockLength(),
                                      enumerator.getEffectivePatternsCount(),
                                      enumerator.getFeasiblePatternsCount());
        System.out.println(result);
        System.out.println("Enumeration takes " + (end - start) + " milliseconds.");
    }

}
