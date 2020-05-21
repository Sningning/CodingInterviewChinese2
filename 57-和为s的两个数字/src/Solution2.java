/**
 * @Author: Song Ningning
 * @Date: 2020-05-21 8:34
 */
public class Solution2 {

    // 双指针
    // 利用递增的性质
    // Time：O(N)；Space：O(1)

    public int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[]{nums[left], nums[right]};
            else if (sum < target)
                left++;
            else
                right--;
        }
        return new int[0];
    }
}
