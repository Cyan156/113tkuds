import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = "";
        String age = "";
        String city = "";

        if(sc.hasNextLine()) name = sc.nextLine();
        if(sc.hasNextLine()) age = sc.nextLine();
        if(sc.hasNextLine()) city = sc.nextLine();

        System.out.println(name);
        System.out.println(age);
        System.out.println(city);
    }
}
