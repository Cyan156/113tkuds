import java.io.*;

public class ds_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請輸入第一個整數：");
        System.out.flush();
        int num1 = Integer.parseInt(reader.readLine());
        System.out.print("請輸入第二個整數：");
        System.out.flush();
        int num2 = Integer.parseInt(reader.readLine());
        int sum = num1 + num2;
        System.out.println("兩個整數的和是：" + sum);
    }
}
