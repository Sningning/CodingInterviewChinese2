/**
 * 面试题10-I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 提示：
 * 0 <= n <= 100
 *
 * @Author: Song Ningning
 * @Date: 2020-05-16 22:20
 */
public class Solution1 {

    /**
     * 递归
     *
     * 直接根据递推公式：F(N) = F(N - 1) + F(N - 2)。但会产生大量重复计算。
     * 时间复杂度: O(2^N)。
     * 空间复杂度: O(N)，占用系统栈空间 O(N)。
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }
}
