

import java.math.BigInteger;

import static src.CombinatoricsTest.combination;

public class Binomial {
    private int n;
    private int k;
    private double p;
    private double q;
    private double result;

    public Binomial(int n, int k, double p) {
        this.n = n;
        this.k = k;
        this.p = p;
        this.q = 1 - p;
        result = 0;
    }
    public Binomial(int n, double p, double result) {
        this.n = n;
        k = 0;
        this.p = p;
        this.q = 1 - p;
        this.result = result;
    }

    // ---------- UTILITIES ----------
    private double logProb(int n, int k, double p) {
        if (p <= 0 || p >= 1) return Double.NEGATIVE_INFINITY;
        BigInteger comb = combination(n, k);
        return Math.log(comb.doubleValue())
                + k * Math.log(p)
                + (n - k) * Math.log(1 - p);
    }

    private double computeResult() {
        if (k < 0 || k > n) return 0;
        BigInteger c = combination(n, k);
        result = c.doubleValue() * Math.pow(p, k) * Math.pow(1 - p, n - k);
        return result;
    }

    private double targetLog() {
        return Math.log(result);
    }
    public double derive(String type) {
        switch (type.toLowerCase()) {
            case "n": return solveForN();
            case "k": return solveForK();
            case "p": return solveForP();
            case "q": return solveForQ();
            default:  System.out.println("Invalid type."); return 0;
        }
    }

    // ---------------------------------------------------------
    //                    SOLVE FOR N
    // ---------------------------------------------------------
    private double solveForN() {
        double target = targetLog();

        // Start searching from n = k
        double prev = logProb(k, k, p);

        for (int i = k + 1; i <= 5000; i++) {
            double curr = logProb(i, k, p);

            // Check match
            if (Math.abs(curr - target) < 1e-7) {
                System.out.println("n ≈ " + i);
                return i;
            }

            // Once logProb starts decreasing past its maximum,
            // and we still haven't hit the target, it's impossible to find.
            if (curr < prev && curr < target) {
                break;
            }

            prev = curr;
        }

        System.out.println("n not found.");
        return -1;
    }

    private double solveForK() {
        double target = targetLog();
        int origK;
        for (int i = 0; i <= n; i++) {
            double val = logProb(n, i, p);
            if (Math.abs(val - target) < 1e-7) {
                System.out.println("k = " + i);
            }
        }
        System.out.println("No matching k");
        return -1;
    }

    private double solveForP() {
        double target = targetLog();
        double left = 0.0000001, right = 0.9999999;

        for (int i = 0; i < 60; i++) { // binary search on p
            double mid = (left + right) / 2;
            double val = logProb(n, k, mid);

            if (val < target) left = mid;
            else right = mid;
        }

        double pSol = (left + right) / 2;
        System.out.printf("p ≈ %.5f%n", pSol);
        return pSol;
    }

    private double solveForQ() {
        if (p > 0) {
            q = 1 - p;
            System.out.printf("q ≈ %.5f%n", q);
            return q;
        }

        // else solve for p first
        double pFound = solveForP();
        q = 1 - pFound;
        System.out.printf("q ≈ %.5f%n", q);
        return q;
    }

    public static void main(String[] args) {
        System.out.println("Test:");
        Binomial b5 = new Binomial(10, 3, 1.0/6.0);
        System.out.println("Result: " + b5.computeResult());
        b5.derive("n");
        b5.derive("k");
        b5.derive("p");
        b5.derive("q");
    }

}
