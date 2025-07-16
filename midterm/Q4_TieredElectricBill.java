import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            int bill = calc(kWh);
            System.out.println("Bill: $" + bill);
            total += bill;
        }

        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    public static int calc(int k) {
        double sum = 0;

        if (k > 1000) {
            sum += (k - 1000) * 8.46;
            k = 1000;
        }
        if (k > 700) {
            sum += (k - 700) * 6.24;
            k = 700;
        }
        if (k > 500) {
            sum += (k - 500) * 5.04;
            k = 500;
        }
        if (k > 330) {
            sum += (k - 330) * 3.70;
            k = 330;
        }
        if (k > 120) {
            sum += (k - 120) * 2.45;
            k = 120;
        }
        sum += k * 1.68;

        return (int) Math.round(sum);
    }
}

/*
 * 時間與空間複雜度分析 (Time and Space Complexity Analysis):
 *
 * 1. 輸入處理：
 *    - 讀取 n 筆用電度數資料，每筆為 O(1)，共 O(n)。
 *
 * 2. 每筆電費計算：
 *    - 每筆呼叫 calc(kWh)，該方法最多經過 6 個 if 區間判斷，皆為固定操作，屬於 O(1)。
 *    - 因此，每筆計算為 O(1)，n 筆合計為 O(n)。
 *
 * 3. 輸出：
 *    - 每筆 bill 輸出一次，以及最後的 total 與 average，總共 O(n)。
 *
 * 總結：
 * - 時間複雜度：O(n)
 * - 空間複雜度：O(1)
 *   - 僅使用常數變數（如 total、avg、sum、k），無額外陣列或資料結構。
 *
 * 備註：
 * - calc() 函式為段式費率計算邏輯，處理過程固定、快速，不會因 kWh 值大小而增加迴圈次數。
 */
