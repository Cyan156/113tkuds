import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] tokens = sc.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }

        int k = Integer.parseInt(sc.nextLine());
        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + a[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
    }
}

/*
 * 時間與空間複雜度分析 (Time and Space Complexity Analysis):
 *
 * 1. 讀取輸入：
 *    - 長度為 n 的整數陣列輸入，使用 split 與 parse，共 O(n)。
 *
 * 2. 建立前綴和陣列 (Prefix Sum)：
 *    - ps[i] = ps[i - 1] + a[i - 1]，總共執行 n 次，加總為 O(n)。
 *
 * 3. 輸出前 k 個 prefix sum 值：
 *    - 印出 ps[1] 到 ps[k]，時間為 O(k)。
 *    - 最多不超過 n，故視為 O(n)。
 *
 * 總體時間複雜度：
 * - O(n) 來自輸入處理與 prefix sum 建構，與輸出加總。
 *
 * 空間複雜度：
 * - 陣列 a[] 使用 O(n) 空間
 * - prefix sum 陣列 ps[] 長度為 n+1，亦為 O(n)
 * - 總空間複雜度為 O(n)
 */
