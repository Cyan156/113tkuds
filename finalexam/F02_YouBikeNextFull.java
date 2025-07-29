import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = toMinutes(sc.nextLine());
        }

        int queryTime = toMinutes(sc.nextLine());

        int left = 0, right = n - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.printf("%02d:%02d\n", times[ans] / 60, times[ans] % 60);
        }
    }

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }ㄋ
}

/*
 * Time Complexity: O(log n)
 * 說明：透過二分搜尋在排序陣列中尋找第一個大於查詢時間的元素，因此時間複雜度為 O(log n)。
 */
