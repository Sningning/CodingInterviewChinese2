/**
 * 面试题16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, (2^31) − 1] 。
 *
 * @Author: Song Ningning
 * @Date: 2020-05-30 9:48
 */
public class Solution1 {

    /*
     * 虽然说不需要考虑大数问题，但是 n 可以取到 -2^31，转换成对应的正数时会超过 int 范围，要使用 long 型
     *
     * 快速幂---可以看做是二分法，递归实现
     */
    public static double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        return fastPow(x, N);
    }

    private static double fastPow(double x, long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double subRes = fastPow(x, n >> 1);
        return (n & 1) == 0 ? subRes * subRes : subRes * subRes * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, -2147483648));  // 0.0
        System.out.println(myPow(2.0, -2));  // 0.25
        System.out.println(myPow(-2.0, -3));  // -0.125
        System.out.println(myPow(2.1, 3));  // 9.261000000000001

    }
}
