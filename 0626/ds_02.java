import java.io.*;

public class ds_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請輸入圓的半徑：");
        double radius = Double.parseDouble(reader.readLine());
        double area = Math.PI * radius * radius;
        System.out.println("圓的面積是：" + area);
    }
}
