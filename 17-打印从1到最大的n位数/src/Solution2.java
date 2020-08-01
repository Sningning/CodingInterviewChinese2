/**
 * @author: Song Ningning
 * @date: 2020-08-01 11:17
 */
public class Solution2 {

    /**
     * 也可以自己写函数实现计算幂运算
     */
    public int[] printNumbers(int n) {
        int max = fastPow(10, n);
        int[] res = new int[max - 1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    /**
     * 快速幂
     * @param base 底数
     * @param exp 指数
     * @return
     */
    private int fastPow(int base, int exp) {
        int ans = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans *= base;
            }
            base *= base;
            exp /= 2;
        }
        return ans;
    }
}
