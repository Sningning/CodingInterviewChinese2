/**
 * @author: Song Ningning
 * @date: 2020-06-21 11:28
 */
public class Solution2 {

    /**
     * 因为 dp[i] 只与 dp[i-1] 相关，因此只需要一个全局变量 res 保存最大和，一个变量 pre 保存之前的最大和。
     * 空间复杂度为 O(1)
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0]; // 全局最大值
        int pre = nums[0]; // 前一个连续子序列最大值
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = {1,-2,3,10,-4,7,2,-5};
        System.out.println(s.maxSubArray(arr1)); // 6
        System.out.println(s.maxSubArray(arr2)); // 18
    }
}
