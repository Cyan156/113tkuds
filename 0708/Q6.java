class Q6 {

    static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    static void showReport(int[] scores) {
        int sum = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            sum += score;

            if (score > max) {
                max = score;
                maxIndex = i;
            }

            if (score < min) {
                min = score;
                minIndex = i;
            }

            char grade = getGrade(score);
            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }
        }

        double average = sum / (double) scores.length;
        int aboveAverage = 0;

        for (int score : scores) {
            if (score > average) {
                aboveAverage++;
            }
        }

        System.out.println("====== 學生成績報告 ======");
        System.out.printf("全班平均分數: %.2f\n", average);
        System.out.printf("最高分: %d（學生編號 %d）\n", max, maxIndex);
        System.out.printf("最低分: %d（學生編號 %d）\n", min, minIndex);
        System.out.printf("高於平均的學生比例: %.2f%%\n", (aboveAverage * 100.0 / scores.length));
        System.out.println("--------------------------");
        System.out.println("等級統計：");
        System.out.println("A 等人數: " + countA);
        System.out.println("B 等人數: " + countB);
        System.out.println("C 等人數: " + countC);
        System.out.println("D 等人數: " + countD);
        System.out.println("--------------------------");
        System.out.println("詳細成績列表：");
        System.out.println("學生編號\t分數\t等級");
        System.out.println("--------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t\t%d\t%c\n", i, scores[i], getGrade(scores[i]));
        }
        System.out.println("==========================");
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        showReport(scores);
    }
}
