import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        int[] results = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            results[i] = sc.nextInt();
        }
        
        
        int k = sc.nextInt();
        
        
        int[] prefixSum = new int[k + 1]; 
        for (int i = 1; i <= k; i++) {
            prefixSum[i] = prefixSum[i - 1] + results[i - 1];
        }
        
       
        System.out.print("PrefixSum: ");
        for (int i = 1; i <= k; i++) {
            System.out.print(prefixSum[i]);
            if (i < k) {
                System.out.print(" ");
            }
        }
        
        sc.close();
    }
}
/*  
 * Time Complexity: O(n)  
 * 說明：前綴和陣列建構時間為 O(n)，查詢時間為 O(1)。  
 */  