class Q4 {

    public static void main(String[] args) {
        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        int max = data[0], min = data[0];
        int maxIndex = 0, minIndex = 0;
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            sum += value;

            if (value > max) {
                max = value;
                maxIndex = i;
            }

            if (value < min) {
                min = value;
                minIndex = i;
            }

            if (value % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        double average = sum / (double) data.length;

        int aboveAverageCount = 0;
        for (int value : data) {
            if (value > average) {
                aboveAverageCount++;
            }
        }

        System.out.println("====== 陣列統計分析 ======");
        System.out.printf("%-20s: %d\n", "總和", sum);
        System.out.printf("%-20s: %.2f\n", "平均值", average);
        System.out.printf("%-20s: %d (索引 %d)\n", "最大值", max, maxIndex);
        System.out.printf("%-20s: %d (索引 %d)\n", "最小值", min, minIndex);
        System.out.printf("%-20s: %d\n", "大於平均值的數量", aboveAverageCount);
        System.out.printf("%-20s: %d\n", "偶數數量", evenCount);
        System.out.printf("%-20s: %d\n", "奇數數量", oddCount);
        System.out.println("==========================");
    }
}
