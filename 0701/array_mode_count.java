public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3,7,3,1,1,1};
        int maxCount = 0;
        int mode = arr[0];
        for (int i = 0 ; i < arr.length;i++){
            int count = 1;
            for (int j = i + 1 ; j<arr.length;j++){
                if (arr[i] == arr[j]){
                    count++;
                }
            }
            System.out.printf("比對中:%d 出現次數=%d%n",arr[i],count);
            if (count > maxCount){
                maxCount = count;
                mode = arr[i];

            }
        }
        System.out.printf("眾數為:%d , 出現%d次%n ",mode,maxCount);

    }
    
}
//時間複雜度為O(n2)