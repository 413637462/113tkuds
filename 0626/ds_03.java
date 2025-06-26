import java.util.Scanner;

public class ds_03{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入名字:");
        String name = sc.nextLine();
        System.out.println("請輸入年齡");
        int age = sc.nextInt();
        System.out.println("請輸入城市:");
        String city = sc.nextLine();
        System.out.println("您好,"+name);
        System.out.println("年齡:"+age);    
        System.out.println("城市:"+city);
        sc.close();
    }
}