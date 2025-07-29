import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[][] items = new String[n][2];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            items[i][0] = parts[0];
            items[i][1] = parts[1];
        }

        Arrays.sort(items, (a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));

        for (int i = 0; i < Math.min(10, n); i++) {
            System.out.println(items[i][0] + " " + items[i][1]);
        }
    }
}

/*
 * Time Complexity: O(n log n)
 * 說明：使用 Arrays.sort 排序 n 筆資料，排序複雜度為 O(n log n)，比插入排序更快。
 * 題目提示插入排序為 O(n^2)，但我們用更有效率的內建排序。
 */
