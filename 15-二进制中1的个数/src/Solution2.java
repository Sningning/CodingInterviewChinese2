/**
 * @author: Song Ningning
 * @date: 2020-05-29 16:41
 */
public class Solution2 {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        /*
         * n & (n−1)
         *
         * (n−1) ： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
         * n & (n - 1)： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
         *
         * n & (n - 1) 效果就是 n 的二进制中的 1 从右往左依次变为 0
         */
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
