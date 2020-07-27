/**
 * @author: Song Ningning
 * @date: 2020-07-27 21:07
 */
public class Solution2 {

    /**
     * 同样，也可以使用有边界与中间位置进行比较。
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return true;
            }
            // 去除一个重复项
            if (nums[mid] == nums[right]) {
                right--;
                continue;
            }
            // mid 在右侧有序部分
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
