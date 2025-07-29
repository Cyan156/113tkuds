import java.util.*;

public class F08_ClimbStairsMemo {
    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        long ways = climb(n);
        System.out.println("Ways: " + ways);
    }

    static long climb(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] != -1) return memo[n];
        memo[n] = climb(n - 1) + climb(n - 2) + climb(n - 3);
        return memo[n];
    }
}

