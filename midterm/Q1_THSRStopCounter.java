import java.util.Scanner;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stop = new String[n];

        for (int i = 0; i < n ; i++){
            stop[1] = sc.next();            
        }

        String start = sc.next();
        String end = sc.next();

        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < n;i++){
            if (stop[i].equals(start)) {
                startIdx = i ;                
            }
            if (stop[i].equals(end)) {
                endIdx = i ;
            }
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        }else {
            int count = Math.abs(endIdx - startIdx) + 1;
            System.out.println(count);
        }

        sc.close();


    }
    
}
/*
 * Time Comlexity: O(n)
 * 說明：遍歷停靠站序列兩次（讀取輸入和查找起訖站），每次時間複雜度為 O(n)。 
 */