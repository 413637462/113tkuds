import java.util.*;
public class prc15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] mat = new int[N][M];
        
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                mat[i][j] = sc.nextInt();
                
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++)
                System.out.print(mat[i][j] + (i < N-1 ? " " : ""));
            System.out.println();
        }
    }
}