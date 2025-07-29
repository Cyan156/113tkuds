import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] incomes = new int[n];
        int[] taxes = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            incomes[i] = Integer.parseInt(sc.nextLine());
            taxes[i] = calculateTax(incomes[i]);
            sum += taxes[i];
        }

        for (int tax : taxes) {
            System.out.println("Tax: $" + tax);
        }

        int avg = sum / n;
        System.out.println("Average: $" + avg);
    }

    static int calculateTax(int income) {
        if (income <= 560000) {
            return (int)(income * 0.05);
        } else if (income <= 1260000) {
            return (int)(income * 0.12 - 39200);
        } else if (income <= 2520000) {
            return (int)(income * 0.20 - 134000);
        } else if (income <= 4720000) {
            return (int)(income * 0.30 - 386000);
        } else {
            return (int)(income * 0.40 - 858000);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入僅需計算一次稅額（O(1)），總共處理 n 筆收入，時間複雜度為 O(n)。
 */
