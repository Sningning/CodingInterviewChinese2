/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author: Song Ningning
 * @date: 2020-06-29 22:43
 */
public class Solution1 {

    /**
     * 因为是有序数组，考虑用二分查找
     * 可以找到 target 在 nums 中第一次出现在位置和最后一次出现的位置，即可确定出出现的次数。
     * 直接套用二分查找模板。
     *
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int firstPos = findFirstPos(nums, target);
        if (firstPos == -1) {
            return 0;
        }
        int lastPos = findLastPos(nums, target);
        return lastPos - firstPos + 1;
    }

    /**
     * 在排序数组 nums 中查找 target 第一次出现的位置
     * @param nums 排序数组
     * @param target 目标数字
     * @return target 在 nums 中第一次出现的位置，不存在返回 -1
     */
    private int findFirstPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] < target) {
                // 这种情况下，[left...mid] 肯定不包含 target
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 在排序数组 nums 中查找 target 最后一次出现的位置
     * @param nums 排序数组
     * @param target 目标数字
     * @return target 在 nums 中最后一次出现的位置，不存在返回 -1
     */
    private int findLastPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >>> 1);
            if (nums[mid] > target) {
                // 这种情况下，[mid...right] 肯定不包含 target
                right = mid - 1;
            } else {
                left = mid; // 这里出现了 left = mid，应该取右中位数
            }
        }
        return nums[right] == target ? right : -1;
    }


    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {5,7,7,8,8,10};
        System.out.println(s.search(arr, 5)); // 1
        System.out.println(s.search(arr, 6)); // 0
        System.out.println(s.search(arr, 7)); // 2
        System.out.println(s.search(arr, 8)); // 2

        System.out.println();

        // 测试 findFirstPos
        System.out.println(s.findFirstPos(arr, 7)); // 1
        System.out.println(s.findFirstPos(arr, 11)); // -1
        System.out.println(s.findFirstPos(arr, 0)); // -1

        System.out.println();

        // 测试 findLastPos
        System.out.println(s.findLastPos(arr, 7)); // 2
        System.out.println(s.findLastPos(arr, 11)); // -1
        System.out.println(s.findLastPos(arr, 0)); // -1
    }
}
