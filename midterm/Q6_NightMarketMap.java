import java.util.Scanner;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        char[][] map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = '#';
            }
        }
        
        
        int m = sc.nextInt();
        
        
        for (int k = 0; k < m; k++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row >= 0 && row < 10 && col >= 0 && col < 10) {
                map[row][col] = '*';
            }
        }
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        sc.close();
    }
}
/*  
 * Time Complexity: O(1)  
 * 說明：固定處理 10x10 地圖，時間複雜度為常數。  
 */  