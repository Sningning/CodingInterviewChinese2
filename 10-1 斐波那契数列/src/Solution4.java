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
public class Solution4 {

    /**
     * 动态规划(空间压缩)
     *
     * 由于动态规划只使用了前两个数，因此可以直接用三个变量来表示结果，循环使用三个变量。
     *
     *
     * 时间复杂度：O(N)。
     * 空间复杂度：O(1)。
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
