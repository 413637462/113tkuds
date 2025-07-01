import java.util.Scanner;
public class searchnubmerbinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s ={1,3,5,7,9,11,13};

        System.out.println("請輸入要查找的數字:");
        int x = sc.nextInt();

        int left = 0;
        int right = s.length -1 ;
        boolean found = false;

        while (left <= right) {
            int mid =(left+right)/2;
            System.out.println("比對中: x =" + x + " , 中間元素 = " + s[mid]);

            if (s[mid] == x){
                found = true;
                break;
            
            }else if (s[mid] < x){
                left = mid + 1;

            }else {
                right = mid -1 ;
            }
            
        }

        
    }
    
}
