import java.util.Scanner;

public class prc17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        
        // 闰年判断条件：
        // 1. 能被4整除但不能被100整除，或者
        // 2. 能被400整除
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}