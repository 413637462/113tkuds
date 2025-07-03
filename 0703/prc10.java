import java.util.Scanner;

public class prc10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M =sc.nextInt();

        int[][] matrix = new int[N][M];

        for (int i = 0;i<N;i++){
            for (int j = 0; j<M;j++){
            matrix[i][j] = sc.nextInt();
            }

        }
        for (int j=0;j<M;j++ ){
            int sum =0;
            for (int i = 0 ; i <N;i++){
                sum += matrix[i][j];
            }
            System.out.print(sum);
            if (j<M-1){
                System.out.println(" ");
            }
        }
    }
    
}
