import java.util.*;
public class q7permutation {
   static int ops = 0;
   static void permute(int[] arr, int l) {
       if (l == arr.length) {
           for (int x : arr) System.out.print(x + " ");
           System.out.println(); ops++;
           return;
       }
       for (int i = l; i < arr.length; i++) {
           swap(arr, i, l);
           permute(arr, l + 1);
           swap(arr, i, l);
       }
   }
   static void swap(int[] arr, int i, int j) {
       int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       for (int i = 0; i < n; i++) arr[i] = i + 1;
       permute(arr, 0);
       System.out.println(ops);
   }
}