/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @author: Song Ningning
 * @date: 2020-07-27 21:09
 */
public class Solution {

    /**
     * 由于是排序数组进行了旋转，还是考虑二分法，就要看 mid 处的元素和左右边界的大小。
     *
     * 看左侧边界：
     * - [3, 4, 5, 1, 2] 中，nums[left] < nums[mid]，最后答案在 mid 右侧。
     * - [1, 2, 3, 4, 5] 中，同样 nums[left] < nums[mid]，但最后答案在 mid 左侧。
     *
     * 看右侧边界：
     * - [3, 4, 5, 1, 2] 中，nums[mid] > nums[right]，说明数组旋转过，mid 肯定不是最小元素，此时更新 left = mid+1，
     *                      去 [mid+1, right] 区间继续寻找。
     * - [4, 5, 1, 2, 3] 中， nums[mid] < nums[right]，说明 [mid, right] 是递增的，但不能确定 mid 是不是最小值，
     *                      因此更新右边界 right = mid，去 [left, mid] 区间继续寻找。
     * - [1, 2, 3, 4, 5] 中，nums[mid] < nums[right]，如果使用相同的逻辑，更新 right = mid，去 [left, mid] 区间进行寻找，是合理的。
     *
     * 不论中间数比右边界大，还是中间数比右边界小，都可以排除掉将近一半的元素。因为是寻找最小值，肯定存在，最后夹逼到一个元素就可以返回，
     * 此时 left == right，返回 nums[left] 或 nums[right] 即可。
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Incorrect input data.");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // 没有重复元素，nums[mid] < nums[right]
                right = mid;
            }
        }
        return nums[left];
    }
}
