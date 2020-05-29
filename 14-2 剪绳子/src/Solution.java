/**
 * @Author: Song Ningning
 * @Date: 2020-05-29 15:31
 */
public class Solution {

    /*
     * 数据范围变得比较大时，long已经不足以去存储中间结果的状态，所以考虑用贪心来做。
     */
    public static int cuttingRope(int n) {

        if (n <= 2)
            return 1;
        if (n == 3)
            return 2;
        if (n == 4)
            return 4;
        long res = 1;
        int mod = 1000000007;
        while (n >= 5) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        res *= n;
        res %= mod;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(120)); // 953271190
    }
}
