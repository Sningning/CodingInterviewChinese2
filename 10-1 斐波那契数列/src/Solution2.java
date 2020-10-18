/**
 * 面试题10-I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 提示：
 * 0 <= n <= 100
 *
 * @author: Song Ningning
 * @date: 2020-05-16 22:20
 */
public class Solution2 {

    /**
     * 记忆化递归(自顶向下)
     *
     * 使用一个备忘录，`memo[i]` 表示第 `i` 项斐波那契数，递归前现在数组中检查，如果没有计算过再去递归计算，
     * 递归返回后，先将结果存入备忘录数组，再返回。
     *
     * 时间复杂度：O(N)。
     * 空间复杂度：O(N)，递归使用 O(N) 堆栈大小。
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;
        return fib(n, memo);
    }

    private int fib(int n, int[] memo) {
        if (n < 2) {
            return memo[n];
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = (fib(n - 1) + fib(n - 2)) % 1000000007;
        return memo[n];
    }
}
