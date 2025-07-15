import java.util.Scanner;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        double[] scores = new double[n];
        
        
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }
        
        
        selectionSort(scores);
        
        
        int top = Math.min(5, n);
        for (int i = 0; i < top; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
        
        sc.close();
    }
    
    
    private static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            
            double temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }
}
/*  
 * Time Complexity: O(n^2)  
 * 說明：選擇排序需執行 n(n-1)/2 次比較與交換，時間複雜度為 O(n^2)。  
 */  