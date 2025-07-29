import java.util.*;
public class F06_ArraySecondLargest {
    public static int[] findMaxAndSecondMax(int[] arr, int index) {
        if (index == arr.length - 1) {
            return new int[]{arr[index], Integer.MIN_VALUE};
        }
        
        int[] result = findMaxAndSecondMax(arr, index + 1);
        int max = result[0];
        int secondMax = result[1];
        
        if (arr[index] > max) {
            return new int[]{arr[index], max};
        } else if (arr[index] > secondMax) {
            return new int[]{max, arr[index]};
        } else {
            return result;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] result = findMaxAndSecondMax(arr, 0);
        System.out.println("SecondMax: " + result[1]);
    }
}

/*
 * Time Complexity: O(n)
 * 說明: 演算法需要遍歷整個陣列一次來找出最大值和第二大值，
 *       每個元素只被處理一次。
 */