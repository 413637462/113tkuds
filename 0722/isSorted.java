public static boolean isSorted(int[] arr, int index) {
    
    if (index == arr.length - 1 || arr.length == 0) {
        return true;
    }
    
    if (arr[index] > arr[index + 1]) {
        return false;
    }
    
    return isSorted(arr, index + 1);
}