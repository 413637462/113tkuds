import java.util.Scanner;
public class ds_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入圓的半徑:");
        double r = input.nextDouble();
        double area = Math.PI*r*r;
        System.out.println("圓的面積為:"+area);
    }

    
}
