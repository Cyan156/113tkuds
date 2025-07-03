import java.util.Scanner;

public class Main19 {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean first = true;
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                if (!first) System.out.print(" ");
                System.out.print(i);
                first = false;
            }
        }
    }
}
