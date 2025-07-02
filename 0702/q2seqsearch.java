import java.util.*;
public class q2seqsearch {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt(), key = 0 ,ops=0;
        int[ ] arr = new int[n];
        for (int i=  0; i<n ; i++) arr[i]=sc.nextInt();
        key =sc.nextInt();
        for (int i=0; i<n;i++){
            ops++;
            if (arr[i] ==key){
                System.out.println("Yes");
                System.out.println(ops);
                return;
            }
        }
        System.out.println("NO");
        System.out.println(ops);
    }
    
}
