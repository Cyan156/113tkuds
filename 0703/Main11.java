import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < M; j++) {
            int colSum = 0;
            for (int i = 0; i < N; i++) {
                colSum += arr[i][j];
            }
            System.out.print(colSum);
            if (j < M - 1) {
                System.out.print(" ");
            }
        }
    }
}
