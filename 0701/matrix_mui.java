public class matrix_mui {
    public static void main(String[] args) {
        int[][] a ={
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };
        int[][] b ={
            {1,2,3},
            {4,5,6},
            {7,8,9},

        };
        int[][] c = new int[3][3];

        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; i ++){
                for ( int k = 0; k <3;k++ ){
                    c[i][j] += a[i][k] * b[k][j];
                }
                
            }
            
        }
        System.out.println("相乘結果:");
        for (int i = 0; i < 3; i++){
            for (int j = 0;j < 3 ;j++){
                System.out.println(c[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
}
