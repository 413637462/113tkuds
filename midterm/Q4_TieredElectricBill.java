import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        int[] kwhs = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            kwhs[i] = sc.nextInt();
        }
        
        int total = 0;
        
        
        for (int i = 0; i < n; i++) {
            int bill = calculateBill(kwhs[i]);
            System.out.println("Bill: $" + bill);
            total += bill;
        }
        
        
        int average = (int) Math.round((double) total / n);
        
        
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + average);
        
        sc.close();
    }
    
    
    private static int calculateBill(int kwh) {
        double bill = 0.0;
        
        if (kwh > 1000) {
            bill += (kwh - 1000) * 8.46;
            kwh = 1000;
        }
        if (kwh > 700) {
            bill += (kwh - 700) * 6.24;
            kwh = 700;
        }
        if (kwh > 500) {
            bill += (kwh - 500) * 5.04;
            kwh = 500;
        }
        if (kwh > 330) {
            bill += (kwh - 330) * 3.70;
            kwh = 330;
        }
        if (kwh > 120) {
            bill += (kwh - 120) * 2.45;
            kwh = 120;
        }
        bill += kwh * 1.68;
        
        return (int) Math.round(bill);
    }
}
/*  
 * Time Complexity: O(n)  
 * 說明：每戶電費計算為 O(1)，總共 n 戶，時間複雜度為 O(n)。  
 */  