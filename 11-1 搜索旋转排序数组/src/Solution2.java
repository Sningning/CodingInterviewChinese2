/**
 * @author: Song Ningning
 * @date: 2020-07-27 20:58
 */
public class Solution2 {

    /**
     * ① 位置取等号，是因为 mid 取的是左中位数，当只有两个元素时，比如 [3,1]，mid = 3，mid 应该是在左侧有序部分。
     * 如果不想取等号的话，因为不存在重复元素，可以将此处的逻辑改为判断 mid 和右边界 right 的关系即可。
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // mid 在右侧有序部分
            // 这里可以不加等号，因为 mid 取得是左中位数
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
        return -1;
    }
}
