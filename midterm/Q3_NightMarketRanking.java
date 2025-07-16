import java.util.*;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(sc.nextLine());
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        int outputCount = Math.min(5, n);
        for (int i = 0; i < outputCount; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
    }
}

/*
 * 時間與空間複雜度分析 (Time and Space Complexity Analysis):
 *
 * 1. 輸入處理：
 *    - 讀取 n 筆評分資料，O(n)。
 *
 * 2. 排序邏輯：
 *    - 採用 Selection Sort（選擇排序）對 scores[] 進行遞減排序。
 *    - 外層執行 n - 1 次，內層最多執行 n - 1 次比較。
 *    - 總比較次數為 n(n - 1) / 2，時間複雜度為 O(n^2)。
 *    - 此排序為原地排序（in-place），不需額外空間。
 *
 * 3. 輸出：
 *    - 輸出最多 5 筆資料，時間為 O(1)。
 *
 * 總結：
 * - 時間複雜度：O(n^2)
 * - 空間複雜度：O(n) 用來儲存 scores[] 陣列
 *
 * 備註：
 * - 適合小型輸入（例如 n ≦ 1000）。
 * - 若資料量較大，可改用 Arrays.sort + 自定 comparator 或其他 O(n log n) 演算法。
 */
