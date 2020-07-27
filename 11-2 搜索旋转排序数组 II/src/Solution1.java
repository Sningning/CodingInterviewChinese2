/**
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * 进阶:
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * @author: Song Ningning
 * @date: 2020-07-27 21:06
 */
public class Solution1 {
    
    /**
     * 和第 33 题类似，不过这里会有重复元素。
     * 当有重复元素时，nums[left] <= nums[mid] 条件不能断定 mid 一定在左侧有序区间，
     * 比如 [1, 0, 1, 1, 1] 和 [1, 1, 1, 0, 1]，前一种情况 mid 是在右侧有序区间，后一种情况 mid 是在左侧有序区间。
     * 因此将这种情况单独判断，如果 nums[left] == nums[mid] ，无法确定在哪个区间，只能将 left 右移一位，相当于排除一个重复项。
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
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            // mid 在左侧有序部分
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
