/**
 * 面试题14- II. 剪绳子 II
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @Author: Song Ningning
 * @Date: 2020-05-29 15:31
 */
public class Solution {

    /*
     * 数据范围变得比较大时，long已经不足以去存储中间结果的状态，所以考虑用贪心来做。
     */
    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1; // 注意
        if (n % 3 == 1) {
            res *= 4;
            n -= 4;
        } else if (n % 3 == 2) {
            res *= 2;
            n -= 2;
        }
        int mod = (int) 1e9+7;
        while (n != 0) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(120)); // 953271190
    }
}
