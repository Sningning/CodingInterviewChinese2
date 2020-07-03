/**
 * @Author: Song Ningning
 * @Date: 2020-07-03 20:45
 */
public class Solution2 {

    /**
     * 异或运算
     *
     * 异或的性质（数学里异或的符号是 ⊕）：
     * 交换律：p ⊕ q = q ⊕ p
     * 结合律：p ⊕ (q ⊕ r) = (p ⊕ q) ⊕ r
     * 恒等率：p ⊕ 0 = p
     * 归零率：p ⊕ p = 0
     *
     * 由于数组中仅有一个数字只出现一次，其他数字均出现两次，因此将数组中的数字异或一遍，
     * 出现两次的数字异或结果为 0，而 p ⊕ 0 = p，因此最后的结果就是所要找的只出现一次的数字。
     */
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
