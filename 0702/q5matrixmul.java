import java.util.*;

public class q5matrixmul {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), ops = 0;
        int[][] A = new int[n][n], B = new int[n][n], C = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) A[i][j] = sc.nextInt();
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) B[i][j] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j]; ops += 2;
                }
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ops);
    }
}


 