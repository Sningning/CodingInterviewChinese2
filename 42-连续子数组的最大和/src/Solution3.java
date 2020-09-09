/**
 * @author: Song Ningning
 * @date: 2020-06-21 11:41
 */
public class Solution3 {

    /**
     * 这种写法也是 Solution2 的变形
     * res 记录全局最大值；preSum 记录之前连续子序列最大值
     * 如果 preSum < 0，preSum 更新为当前值；否则 加上当前值。同时更新 res
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preSum < 0) {
                preSum = nums[i];
            } else {
                preSum += nums[i];
            }
            if (preSum > res) {
                res = preSum;
            }
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
