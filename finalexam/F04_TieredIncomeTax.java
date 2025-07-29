import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] incomes = new int[n];
        int[] taxes = new int[n];

        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
            taxes[i] = calculateTax(incomes[i]);
            System.out.println("Tax: $" + taxes[i]);
        }

        int sum = 0;
        for (int tax : taxes) {
            sum += tax;
        }
        System.out.println("Average: $" + (sum / n));
    }

    public static int calculateTax(int income) {
        int tax = 0;
        int[] limits = {540000, 1210000, 2420000, 4530000};
        int[] rates = {5, 12, 20, 30, 40};
        int[] brackets = new int[5];

        brackets[0] = Math.min(income, limits[0]);
        if (income > limits[0])
            brackets[1] = Math.min(income, limits[1]) - limits[0];
        if (income > limits[1])
            brackets[2] = Math.min(income, limits[2]) - limits[1];
        if (income > limits[2])
            brackets[3] = Math.min(income, limits[3]) - limits[2];
        if (income > limits[3])
            brackets[4] = income - limits[3];

        for (int i = 0; i < 5; i++) {
            tax += brackets[i] * rates[i] / 100;
        }

        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：對每筆收入一次計算稅額，單筆稅計算為常數次操作，共 n 筆資料，因此為 O(n)。
 */
