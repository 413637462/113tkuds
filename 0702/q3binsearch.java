import java.util.*;
import jdk.jshell.spi.ExecutionControl;
public class q3binsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),key = 0,ops=0;
        int[] arr = new int[n];
        for (i = 0;i<n;i++) arr[i] = sc.nextInt();
        key = sc.nextInt();
        int l = 0; r =n-1;
        while (i<=r){
            ops++;
            int m =(l+r)/ 2;
            if (arr[m]==key){
                System.out.println(m);
                System.out.println(ops);
                return;
            }
            if(arr[m]<key) l =m+1;

        }
        System.out.println(-1);
        System.out.println(ops);

    }
    
}
