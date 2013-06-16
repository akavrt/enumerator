package com.akavrt.csp.enumerator;

/**
 * <p>Pattern enumerator based on algorithm proposed by Pierce (1964). Can be used to evaluate the
 * number of both effective and feasible patterns for a particular 1D-CSP.</p>
 *
 * @author Victor Balabanov <akavrt@gmail.com>
 */
public class Enumerator {
    private final long stockLength;
    private final long[] lengths;
    private final long[] demands;
    private final long[] cuts;
    private long effectiveCounter;
    private long feasibleCounter;

    public Enumerator(Problem problem) {
        stockLength = problem.getStockLength();

        problem.prepare();

        lengths = new long[problem.size()];
        demands = new long[problem.size()];
        for (int i = 0; i < problem.size(); i++) {
            Order order = problem.getOrder(i);
            lengths[i] = order.getLength();
            demands[i] = order.getQuantity();
        }

        cuts = new long[problem.size()];
    }

    /**
     * <p>Pierce used term 'dominating processes' to denote the set of effective patterns.</p>
     *
     * @return number of effective patterns.
     */
    public long getEffectivePatternsCount() {
        return effectiveCounter;
    }

    /**
     * <p>Pierce used term 'exhaustive processes' to denote the set of feasible patterns.</p>
     *
     * @return number of feasible patterns.
     */
    public long getFeasiblePatternsCount() {
        return feasibleCounter;
    }

    /**
     * <p>Enumerates patterns in sequential manner using algorithm proposed by Pierce (1964).</p>
     */
    public void enumerate() {
        effectiveCounter = 0;
        feasibleCounter = 0;

        int j = -1;
        do {
            if (j >= 0) {
                cuts[j]--;
            }

            long unused = stockLength;
            int k = -1;
            for (int i = 0; i < cuts.length; i++) {
                if (i > j) {
                    long upperBound = unused / lengths[i];
                    cuts[i] = Math.min(upperBound, demands[i]);
                }

                unused -= cuts[i] * lengths[i];

                if (cuts[i] > 0) {
                    k = i;
                }
            }

            j = k;

            if (unused < stockLength) {
                feasibleCounter++;

                if (unused < lengths[lengths.length - 1]) {
                    effectiveCounter++;
                }
            }
        }
        while (j >= 0);
    }
}
