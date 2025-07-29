import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int lastSpace = line.lastIndexOf(' ');
            names[i] = line.substring(0, lastSpace);
            qtys[i] = Integer.parseInt(line.substring(lastSpace + 1));
        }

        for (int i = 1; i < n; i++) {
            String tempName = names[i];
            int tempQty = qtys[i];
            int j = i - 1;
            while (j >= 0 && qtys[j] < tempQty) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            names[j + 1] = tempName;
            qtys[j + 1] = tempQty;
        }

        int outputCount = Math.min(10, n);
        for (int i = 0; i < outputCount; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：使用插入排序處理最多 200 筆資料，最壞情況下每個元素都需與前面所有元素比較與移動，因此時間複雜度為 O(n^2)。
 */
