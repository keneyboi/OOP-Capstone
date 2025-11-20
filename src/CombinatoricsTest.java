/*
    NOTE:
        This is for copying purposes. I vibe-coded pretty much everything but this should all work properly even
        for extremely large numbers, because we're not using factorial (in code, if this was utilizing long, it
        would fail at 20!). I'm also using BigInteger so that the only limit is memory, no overflows. Factorial
        computation, even with BigInteger, will take so long to compute and might be a bad practice (I haven't
        tested actually if it works).

        If other formulas can make use of factorization for cancelling instead of factorial, this code snippet
        can help :DD.
        - Asterialumi (John Vincent Balazon)
 */


import java.util.*;
import java.math.BigInteger;

public class CombinatoricsTest {

    // BigInteger version of gcd
    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return a.gcd(b); // Built-in function in BigInteger
    }

    // Compute nCk using cancellation (no factorials)
    public static BigInteger combination(int totalItems, int chooseCount) {

        if (chooseCount > totalItems) return BigInteger.ZERO;

        if (chooseCount > totalItems - chooseCount)
            chooseCount = totalItems - chooseCount;

        // Use BigInteger arrays
        BigInteger[] numeratorTerms = new BigInteger[chooseCount];
        BigInteger[] denominatorTerms = new BigInteger[chooseCount];

        // Fill numerator: n, n-1, ..., n-k+1
        for (int i = 0; i < chooseCount; i++) {
            numeratorTerms[i] = BigInteger.valueOf(totalItems - i);
        }

        // Fill denominator: 1, 2, ..., k
        for (int i = 0; i < chooseCount; i++) {
            denominatorTerms[i] = BigInteger.valueOf(i + 1);
        }

        // Cancellation using gcd
        for (int i = 0; i < chooseCount; i++) {
            for (int j = 0; j < chooseCount; j++) {

                BigInteger g = gcd(numeratorTerms[i], denominatorTerms[j]);

                if (!g.equals(BigInteger.ONE)) {
                    numeratorTerms[i] = numeratorTerms[i].divide(g);
                    denominatorTerms[j] = denominatorTerms[j].divide(g);
                }
            }
        }

        // Multiply remaining numerator terms
        BigInteger result = BigInteger.ONE;

        for (int i = 0; i < chooseCount; i++) {
            result = result.multiply(numeratorTerms[i]);
        }

        return result;
    }

    // Compute nCk using cancellation (no factorials), shorter because it can only cancel one time (from n to n - k)
    public static BigInteger permutation(int totalItems, int chooseCount) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < chooseCount; i++) {
            result = result.multiply(BigInteger.valueOf(totalItems - i));
        }
        return result;
    }

    // FOR DEBUGGING
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and r: ");
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println("Combination" + n + " choose " + r + ": " + CombinatoricsTest.combination(n, r));
        System.out.println("Permutation" + n + " things taken " + r + " at a time: " + CombinatoricsTest.permutation(n, r));
    }
}
