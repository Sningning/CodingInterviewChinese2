/**
 * 面试题10-II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 提示：
 * 0 <= n <= 100
 *
 * @Author: Song Ningning
 * @Date: 2020-05-16 22:49
 */
public class Solution {

    public int numWays(int n) {

        int f1 = 1, f2 = 1, fn = 1;
        for (int i = 1; i < n; i++) {
            fn = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
