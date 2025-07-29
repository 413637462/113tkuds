import java.util.*;

public class F05_LCMRecursive {
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int lcm = a * b / gcd(a, b);
        System.out.println("LCM: " + lcm);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明: 最壞情況下，輾轉相減法需要遞迴 max(a, b) 次才能得到結果，
 *       例如當 a 和 b 互質時，需要遞迴 max(a, b) 次。
 */