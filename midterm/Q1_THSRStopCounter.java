import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] stops = sc.nextLine().split(" ");
        String start = sc.next();
        String end = sc.next();

        int startIdx = -1, endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIdx = i;
            }
            if (stops[i].equals(end)) {
                endIdx = i;
            }
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }
    }
}

/*
 * 時間複雜度分析 (Time Complexity Analysis):
 *
 * - 輸入讀取與分割：
 *   - sc.nextLine().split(" ") 會將站名分割為陣列，時間為 O(n)，其中 n 為站數。
 *
 * - 尋找起點與終點索引：
 *   - 一次 for 迴圈掃描 stops[] 陣列，共執行 n 次比較操作，時間為 O(n)。
 *
 * - Math.abs 與 println 為常數時間操作，O(1)。
 *
 * 綜合：
 * - 整體時間複雜度為 O(n)，主要花費在輸入解析與搜尋站名索引。
 * - 空間複雜度為 O(n)，用來儲存 stops[] 陣列。
 */
