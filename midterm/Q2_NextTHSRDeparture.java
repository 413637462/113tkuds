import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        sc.nextLine(); 
        
        int[] times = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            String timeStr = sc.nextLine().trim();
            times[i] = convertToMinutes(timeStr);
        }
        
        
        String queryStr = sc.nextLine().trim();
        int query = convertToMinutes(queryStr);
        
        
        int idx = binarySearch(times, query);
        
        
        if (idx < n) {
            System.out.println(formatMinutes(times[idx]));
        } else {
            System.out.println("No train");
        }
        
        sc.close();
    }
    
    
    private static int convertToMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    
    private static String formatMinutes(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return String.format("%02d:%02d", hours, minutes);
    }
    
    
    private static int binarySearch(int[] times, int query) {
        int left = 0;
        int right = times.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (times[mid] > query) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
/*  
 * Time Complexity: O(log n)  
 * 說明：二分搜尋的時間複雜度為 O(log n)，轉換時間為 O(1)。  
 */  