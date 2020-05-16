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
public class Solution {

    public static int fib(int n) {


        // if (n < 2)
        //     return n;
        // if (n == 2)
        //     return 1;
        // int f1 = 1;
        // int f2 = 1;
        // int fn = 1;
        // for (int i = 3; i <= n; i++) {
        //     fn = (f1 + f2) % 1000000007;
        //     f1 = f2;
        //     f2 = fn;
        // }
        // return fn;

        if (n < 2)
            return n;
        int f1 = 0;
        int f2 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
    }
}
