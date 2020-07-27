/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author: Song Ningning
 * @date: 2020-07-27 20:54
 */
public class Solution1 {

    /**
     * 题目中要求时间复杂度是 O(logN)，因此考虑用二分法。
     * 数组在某个位置进行旋转，因此，旋转点可能在数组靠前、靠后或中间位置。
     * 
     * 但是，旋转点不管靠前靠后还是中间，mid 总会将数组一分为二，且 mid 一定会落在一个有序区间中。
     * 因此只要确定出 一个有序区间，这样就可以在有序区间中进行二分查找。
     *
     * 怎样确定某个有序区间？可以根据 nums[left]、nums[mid]、nums[right]的大小关系来确定。这里选择中位数与左边界来确定。
     *
     * 情况 1：nums[left] <= nums[mid]，即左边界的值小于等于中间位置的值。此时区间 [left, mid] 一定是有序的。
     *        target 要么在有序区间 [left, mid] 中，要么在 [mid+1, right] 中。
     *        - 如果 nums[left] <= target < nums[mid]，说明 target 在有序区间里，直接调整 right = mid - 1；
     *          因为在前面我们可以先判断 target 与 nums[mid] 的关系，执行到这里，说明 target  肯定不等于 nums[mid]，
     *          right 可以直接更新为 mid - 1 ；nums[left] <= target 必须要加等号，如果不加等号，当 nums[left] == target 时，
     *          会执行 left = mid + 1，跳过了正解，例如：[1, 2, 3]，target = 1。
     *        - 剩下的情况就直接调整 left = mid + 1。
     *
     * 情况 2：nums[left] > nums[mid]，即左边界的值大于中间位置的值。此时区间 [mid, right] 一定是有序的。
     *        target 要么在有序区间 [left, mid-1] 中，要么在 [mid, right] 中。
     *        - 如果 nums[mid] < target <= nums[right]，说明 target 在有序区间里，直接调整 left = mid + 1；
     *          target <= nums[right] 必须要加等号，如果不加等号，当 target == nums[right] 时，会执行 right = mid - 1，
     *          跳过了正解，例如：[3, 1, 2]，target = 2。
     *        -  剩下的情况就直接调整 right = mid - 1。
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            // 直接命中
            if (nums[mid] == target) {
                return mid;
            }
            // mid 在左侧有序部分
            // ① 需要取到等号
            if (nums[left] <= nums[mid]) {
                // 前面需要取到等号
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 后面需要取到等号
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
