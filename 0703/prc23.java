import java.util.Scanner;

public class prc23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(factorial(N));
    }
    
    private static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n-1);
    }
}