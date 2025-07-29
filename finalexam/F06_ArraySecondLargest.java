import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int[] result = findMaxSecond(arr, 0, n - 1);
        System.out.println("SecondMax: " + result[1]);
    }

    // 回傳 int[]{最大值, 第二大值}
    static int[] findMaxSecond(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left], Integer.MIN_VALUE};
        }

        int mid = (left + right) / 2;
        int[] leftPair = findMaxSecond(arr, left, mid);
        int[] rightPair = findMaxSecond(arr, mid + 1, right);

        int max1 = Math.max(leftPair[0], rightPair[0]);
        int max2;
        if (leftPair[0] > rightPair[0]) {
            max2 = Math.max(leftPair[1], rightPair[0]);
        } else if (rightPair[0] > leftPair[0]) {
            max2 = Math.max(rightPair[1], leftPair[0]);
        } else {
            max2 = Math.max(leftPair[1], rightPair[1]);
        }

        return new int[]{max1, max2};
    }
}

/*
 * Time Complexity: O(n)
 * 說明：使用 divide and conquer，將陣列拆分成左右兩半再合併，每個元素都會被訪問一次，因此總時間複雜度為 O(n)。
 */
