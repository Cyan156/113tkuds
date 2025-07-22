public class Q3_DigitSum {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Digit sum of " + n + " is " + digitSum(n)); // 輸出 15
    }

    public static int digitSum(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + digitSum(n / 10);
    }
}
