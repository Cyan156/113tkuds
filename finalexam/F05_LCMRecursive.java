import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcdRecursive(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    static int gcdRecursive(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcdRecursive(a - b, b);
        else return gcdRecursive(a, b - a);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法在最壞情況下，每次遞迴只減少 1，最多會遞迴 max(a, b) 次，因此時間複雜度為 O(max(a, b))。
 */
