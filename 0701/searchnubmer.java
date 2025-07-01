import java.util.Scanner;

public class searchnubmer{
    public static void main(String[] args) {
        int[] s ={1,3,5,7,9,11,13};
        Scanner sc = new Scanner(System.in);

        System.out.println("請輸入要查找的數字:");
        int x = sc.nextInt();
        boolean found = false;

        for (int num :s ){
            System.out.println("比對中:x = " + x +",目前元素 ="+num);
            if (num == x){
                found = true ;
                break ;
            }
        }
        if (found){
            System.out.println("找到數字"+ x + "!");
        }else{
            System.out.println("沒找到數字"+x+"。");
        }
        
        sc.close();
    }

}