public class ds_06 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int max = Integer.MIN_VALUE;
        System.out.println("隨機陣列內容:");
        for (int i = 0 ; i < arr.length; i ++){
            arr[i] = (int)(Math.random()*100);
            System.out.print(arr[i]+" " );
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("\n最大值為:"+max);
    }
    
}
