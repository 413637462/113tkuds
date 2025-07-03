import java.util.Scanner;

public class prc21 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        // 使用数学公式计算：偶数和 = 2 + 4 + ... + 2k = k*(k+1)
        int k = N / 2;
        System.out.println(k * (k + 1));
    }
}