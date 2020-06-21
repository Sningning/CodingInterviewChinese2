/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 注意：本题与力扣 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-21 10:11
 */
public class Solution1 {

    /**
     * 动态规划
     * 状态：dp[i] 代表以 nums[i] 结尾的连续子序列的最大和；
     * 初始值：dp[0] = nums[0];
     * 状态转移：
     *     如果 dp[i - 1] < 0：nums[i] + dp[i - 1] < nums[i]，此时 dp[i] = nums[i]；
     *     如果 dp[i - 1] >= 0：nums[i] + dp[i - 1] >= nums[i]，此时 dp[i] = nums[i] + dp[i - 1]；
     *     即 dp[i] = max{nums[i], nums[i] + dp[i - 1]}
     * 结果返回：需要遍历 dp 数组，找到最大的返回。
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = {1,-2,3,10,-4,7,2,-5};
        System.out.println(s.maxSubArray(arr1)); // 6
        System.out.println(s.maxSubArray(arr2)); // 18
    }
}
