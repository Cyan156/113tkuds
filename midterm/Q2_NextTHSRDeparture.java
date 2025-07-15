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
 * Time Complexity: O(n)
 * 說明：
 * - 最多比較 n 次字串直到找到下一班列車。
 * - 輸入已排序，不需要額外排序操作。
 */
