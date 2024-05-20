package com.jackdawl.recursion;

public class FibonacciImplementation {


    public static void main(String[] args) {
        cache = new long[50];
        for (int i = 1; i <= 50; i++) {
            long start = System.currentTimeMillis();
//            System.out.println(i + ": " + cacheRecFib(i) + ", take times: " + (System.currentTimeMillis() - start) + "ms");
            System.out.println(i + ": " + tailRecFib(i, 1, 1) + ", take times: " + (System.currentTimeMillis() - start) + "ms");
        }
    }


    /**
     * Implement Fibonacci function recursively
     *
     * @param n Greater than 0
     * @return long type value
     */
    public static long recFib(int n) {
        if (n <= 2) {
            return 1;
        }
        return recFib(n - 1) + recFib(n - 2);
    }


    /**
     * Fibonacci function is implemented using loops
     *
     * @param n Greater than 0
     * @return long type value
     */
    public static long loopFib(int n) {
        if (n <= 2) {
            return 1;
        }
        long a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }


    private static long[] cache;

    /**
     * Implement Fibonacci function recursively
     * and add a cache to save intermediate res
     *
     * @param n Greater than 0
     * @return long type value
     */
    public static long cacheRecFib(int n) {
        if (n <= 2) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        long res = cacheRecFib(n - 1) + cacheRecFib(n - 2);
        cache[n] = res;
        return res;
    }

    /**
     * Implement Fibonacci is implemented using tail recursion
     *
     * @param n   Greater than 0
     * @param res The result of the current calculation
     * @param pre The result of the previous calculation
     * @return long type value
     */
    public static long tailRecFib(int n, long res, long pre) {
        if (n <= 2) {
            return res;
        }
        return tailRecFib(n - 1, res + pre, res);
    }


}
