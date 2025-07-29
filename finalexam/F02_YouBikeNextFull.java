import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            times[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }

        String query = sc.nextLine();
        String[] qParts = query.split(":");
        int qTime = Integer.parseInt(qParts[0]) * 60 + Integer.parseInt(qParts[1]);

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (times[i] >= qTime) {
                int hour = times[i] / 60;
                int minute = times[i] % 60;
                System.out.printf("%02d:%02d\n", hour, minute);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No bike");
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：一行行搜尋每筆補車時間，直到找到大於等於查詢時間的第一筆，因此是 O(n)。
 */
