import java.util.*;
public class prc24 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

       for (int i = 0; i < n / 2; i++) {
           int temp = arr[i];
           arr[i] = arr[n-1-i];
           arr[n-1-i] = temp;
       }

       for (int i = 0; i < n; i++) {
           System.out.print(arr[i] + (i < n-1 ? " " : ""));
       }
   }
}