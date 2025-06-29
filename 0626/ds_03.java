import java.io.*;

public class ds_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("請輸入姓名：");
        String name = reader.readLine();

        System.out.print("請輸入年齡：");
        int age = Integer.parseInt(reader.readLine());

        System.out.print("請輸入城市：");
        String city = reader.readLine();

        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("城市：" + city);
    }
}
