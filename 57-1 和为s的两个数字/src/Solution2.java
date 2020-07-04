/**
 * @Author: Song Ningning
 * @Date: 2020-05-21 8:34
 */
public class Solution2 {

    /**
     * 双指针
     * 利用数组递增的性质，将当前指针指向的两个数字之和与 target 比较。
     *
     * Time：O(N)；Space：O(1)
     */
    public static int[] twoSum(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target)
                lo++;
            else if (sum > target)
                hi--;
            else
                return new int[]{nums[lo], nums[hi]};
        }
        return new int[0];
    }
}
