import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] times = new String[n];
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextLine();
        }

        String query = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (times[i].compareTo(query) > 0) {
                System.out.println(times[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No train");
        }
    }
}

/*
 * 時間複雜度分析 (Time Complexity Analysis):
 *
 * - 輸入處理：
 *   - 讀取 n 行時間字串，時間為 O(n)，每行視為一個已排序的時間資料。
 *   - 額外再讀取 1 行查詢時間，O(1)。
 *
 * - 查找邏輯：
 *   - 最多比較 n 次字串（compareTo），直到找到第一個晚於 query 的時間。
 *   - 在最壞情況（query 比所有列車時間都晚）下，需走訪整個 times 陣列。
 *   - 時間複雜度為 O(n)。
 *
 * - 因為輸入已排序，不需額外排序。
 *   - 若使用二分搜尋可進一步優化為 O(log n)（但目前為線性掃描）。
 *
 * 空間複雜度 (Space Complexity):
 * - 儲存 n 筆列車時間字串至陣列 times[]，空間複雜度為 O(n)。
 * - 其餘為常數空間 (O(1)) 變數，如 query, found 等。
 *
 * 綜合：
 * - 時間複雜度：O(n)
 * - 空間複雜度：O(n)
 */
