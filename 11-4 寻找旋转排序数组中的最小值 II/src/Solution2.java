/**
 * @Author: Song Ningning
 * @Date: 2020-05-18 22:02
 */
public class Solution2 {

        /**
         * 和之前的思路一样，对于 [3, 1, 2, 3, 3, 3, 3]，nums[mid] == nums[right]，正确结果在 mid 左侧；
         * 对于 [3, 3, 3, 3, 1, 2, 3]，nums[mid] == nums[right]，正确结果在 mid 右侧。
         * 因此此时无法判断，只能将 right 向左移动一位，排除一个重复元素。
         */
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("Incorrect input data.");
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + ((right - left) >>> 1);
                // 排除一个重复元素
                if (nums[mid] == nums[right]) {
                    right--;
                } else if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
}