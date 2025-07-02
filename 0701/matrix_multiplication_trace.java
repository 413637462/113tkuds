
import javax.swing.SpinnerDateModel;

public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}}; 
        int[][] b = {{5,6},{7,8}};
        int[][] c = new int[2][2];
        for (int i = 0 ; i < 2 ; i++){
            for (int j = 0 ; j <2 ; j++){
                System.out.printf("計算位置 c[%d][%d]:",i,j);
                int sum=0;
                for (int k = 0; k<2;k++){
                    int product = a[i][k] * b[k][j];
                    if (k == 0){
                        System.out.printf("%d*%d", a[i][k], b[k][j]);
                    
                    }else{
                        System.out.printf("+ %d*%d", a[i][k],b[k][j]);
                    }
                    sum +=product;
                }
            }System.out.printf("=%d%n",sum);
            c[i][j] = sum;
        }
    }System.out.println("結果矩陣:");
     for (int[] row : c){
        for (int num : row){
            System.out.print(num+"\t");
        }
        System.out.println();
    }
}
//時間複雜度為O(n3) 