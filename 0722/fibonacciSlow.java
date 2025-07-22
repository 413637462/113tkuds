
public static int fibonacciSlow(int n) {
    if (n <= 1) return n;
    return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
}


public static int fibonacciFast(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];  
    memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
    return memo[n];
}
// 时间复杂度：O(n) - 每个数字只计算一次
// 空间复杂度：O(n) - 存储计算结果


public static int fibonacciFast(int n) {
    int[] memo = new int[n + 1];
    return fibonacciFast(n, memo);
}