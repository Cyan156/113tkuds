public class Q7_FibonacciCompare {
    public static void main(String[] args) {
        int n = 40;

        // 標準遞迴
        long startSlow = System.currentTimeMillis();
        int resultSlow = fibonacciSlow(n);
        long endSlow = System.currentTimeMillis();
        System.out.println("Slow Fibonacci(" + n + ") = " + resultSlow + ", time = " + (endSlow - startSlow) + "ms");

        // 記憶化版本
        int[] memo = new int[n + 1];
        long startFast = System.currentTimeMillis();
        int resultFast = fibonacciFast(n, memo);
        long endFast = System.currentTimeMillis();
        System.out.println("Fast Fibonacci(" + n + ") = " + resultFast + ", time = " + (endFast - startFast) + "ms");
    }

    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }
}
