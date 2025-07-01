public  class array_sum_trace{
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int total = 0 ;
        for (int num : arr){
            System.out.printf("加總過程:total = %d+%d = %d%n",total,num,total+num);
            total +=num;
        }
        System.out.println("總和為:"+total);
    }

}
//時間複雜度:為O(n),遍歷陣列一次,每個元素只被訪問一次