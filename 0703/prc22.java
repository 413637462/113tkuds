import java.util.*;
public class prc22{
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        for (int i = 1; i <= N; System.out.println(), i++)
            for (int j = 1; j <= N; j++)
                System.out.printf("%4d", i*j);
    }
}