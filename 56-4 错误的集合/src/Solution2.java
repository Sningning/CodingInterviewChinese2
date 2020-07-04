/**
 * @Author: Song Ningning
 * @Date: 2020-07-04 15:24
 */
public class Solution2 {

    /**
     * 位运算——异或运算
     *
     * 首先将 1~n 的数字异或，结果为 x，然后将 nums 中每个数与 x 异或，结果记为 k，由于只有一个数字缺失，一个数字重复，
     * 假设 重复的数字为 p，缺失的数字为 q，则 k = p xor q。
     * 比如：[1,2,2,4] 和 [1,2,3,4]，最后异或的结果就是 2^3。
     *
     * 接下来的思路和 力扣 260. 只出现一次的数字 III 相同，先找到 k 二进制最右侧的 1，然后将数组中的元素分为两组，
     * 再将 1~n 分为两组，两组中的元素各自异或，结果为 p 和 q，但是并不知道哪个是缺失的，哪个是重复的，最后遍历一边数组确定。
     * 比如：[1,2,2,4] 和 [1,2,3,4]，异或后结果 k = 1;
     * 首先将 nums 分成两组：[1] 和 [2,2,4]; 再将 1~n 分成两组：[1,3] 和 [2,4]。
     * 然后 [1] 和 [1,3] 异或，结果为 3；[2,2,4] 和 [2,4] 异或，结果为 2.
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        // 1~n 的异或结果
        int k = 0;
        for (int i = 1; i <= n; i++) {
            k ^= i;
        }
        // 与数组中每个数字异或
        for (int num : nums) {
            k ^= num;
        }
        // int mask = k & (-k); 另一种找到 mask 的方法
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int p = 0;
        int q = 0;
        // 将数组元素分成两组
        for (int num : nums) {
            if ((num & mask) == 0) {
                p ^= num;
            } else {
                q ^= num;
            }
        }
        // 将1~n 分成两组
        for (int i = 1; i <= n; i++) {
            if ((i & mask) == 0) {
                p ^= i;
            } else {
                q ^= i;
            }
        }
        // 最后遍历一遍数组，确定哪个是缺失的哪个是重复的
        for (int num : nums) {
            if (num == p) {
                return new int[]{p, q};
            }
        }
        return new int[]{q, p};
    }
}
