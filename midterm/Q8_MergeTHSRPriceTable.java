import java.util.*;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] stations = new String[n];
        int[][] prices = new int[n][2];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            stations[i] = parts[0];
            prices[i][0] = Integer.parseInt(parts[1]);
            prices[i][1] = Integer.parseInt(parts[2]);
        }

        System.out.println("Station|Standard|Business");
        for (int i = 0; i < n; i++) {
            // 假設欄寬：Station 7字元，Standard 8字元，Business 8字元，左靠右靠調整
            System.out.printf("%-7s|%8d|%8d\n", stations[i], prices[i][0], prices[i][1]);
        }
    }
}

