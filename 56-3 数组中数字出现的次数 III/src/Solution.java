import java.util.Arrays;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 本题与力扣 137. 只出现一次的数字 II 相同 https://leetcode-cn.com/problems/single-number-ii/
 *
 * @Author: Song Ningning
 * @Date: 2020-07-03 22:20
 */
public class Solution {

    /**
     * 可以使用哈希表，先遍历数组，记录每个数出现的次数，再遍历 map，找到只出现一次的数字。
     * 时间复杂度 O(N); 空间复杂度：O(N)。简单，不再写代码。
     *
     * 还可以排序，如果一个数和前后都不相等，该数就是要找的数字。
     * 排序的做法需要单独判断第一位和最后一位。
     * 时间复杂度：O(NlogN)；空间复杂度：O(1)
     */
    static class Solution1 {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            if (len == 1 || nums[0] != nums[1]) {
                return nums[0];
            }
            for (int i = 1; i < len - 1; i++) {
                if ((nums[i - 1] != nums[i]) && (nums[i] != nums[i + 1])) {
                    return nums[i];
                }
            }
            return nums[len - 1];
        }
    }


    /**
     * 如果一个数字出现三次，那么它的二进制表示的每一位也出现三次，如果把所有出现三次的数字的二进制表示
     * 的每一位分别相加，那么每一位的和一定都能被 3 整除。
     * 将数组中所有数字的二进制表示的每一位都加起来：
     *     如果某一位的和能被 3 整除，那么那个只出现一次的数字的二进制表示中对应的那一位为 0；
     *     如果不能被 3 整除，那个只出现一次的数字的二进制表示中对应的那一位为 1。
     * 时间复杂度：O(N)；空间复杂度：O(1)
     */
    static class Solution2 {
        public int singleNumber(int[] nums) {
            int res = 0;
            // int 32位
            for (int i = 0; i < 32; i++) {
                int sum = 0;
                for (int num : nums) {
                    if ((num & (1 << i)) != 0) {
                        sum++;
                    }
                }
                // 计算完当前当前位后进行判断
                if (sum % 3 != 0) {
                    res += (1 << i);
                }
            }
            return res;
        }
    }
}
