import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 1;
        for (int z = 0; z < N; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    System.out.print(num);
                    num++;
                    if (x < N - 1) System.out.print(" ");
                }
                System.out.println();
            }
            if (z < N - 1) System.out.println();
        }
    }
}

