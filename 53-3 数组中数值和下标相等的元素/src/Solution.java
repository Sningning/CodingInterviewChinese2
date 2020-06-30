/**
 * 剑指 Offer 53 - III. 数组中数值和下标相等的元素
 *
 * 假设一个单调递增的数组里的每一个元素都是整数并且是唯一的。
 * 实现一个函数，找出数组中任意一个数值等于其下标的元素。
 *
 * 示例:
 * 输入: [-3,-1,1,3,5]
 * 输出: 3
 * 解释：数字 3 和它的下标相等。
 *
 * @Author: Song Ningning
 * @Date: 2020-06-30 17:06
 */
public class Solution {

    public static int findNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (mid == nums[mid]) {
                return mid;
            } else if (mid > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {0};
        int[] arr2 = {1};
        int[] arr3 = {-3,-1,1,3,5};
        int[] arr4 = {-3,-1,1,2,4};
        int[] arr5 = {0,2,3,4,5};
        System.out.println(findNumber(arr1)); // 0
        System.out.println(findNumber(arr2)); // -1
        System.out.println(findNumber(arr3)); // 3
        System.out.println(findNumber(arr4)); // 4
        System.out.println(findNumber(arr5)); // 0
    }
}
