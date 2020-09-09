/**
 * @author: Song Ningning
 * @date: 2020-06-30 15:43
 */
public class Solution2 {

    /**
     * 另一种写法
     */
    public static int search(int[] nums, int target) {
        return searchInsert(nums, target) - searchInsert(nums, target - 1);
    }

    /**
     * 查找数字 target 在排序数组 nums 中的插入点，若数组中存在值相同的元素，则插入位置为这些元素的右边。
     * @param nums 排序数组
     * @param target 目标值
     * @return target 在排序数组中的插入位置，如果有多个 target，位置为重复元素的右侧
     */
    private static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {

        // 测试 searchInsert 函数
        int[] arr1 = {1,2,2,3,3,4,5};
        int[] arr2 = {1,3,5,6};
        System.out.println(searchInsert(arr1, 6)); // 7
        System.out.println(searchInsert(arr1, 0)); // 0
        System.out.println(searchInsert(arr1, 3)); // 5
        System.out.println(searchInsert(arr2, 5)); // 3

        System.out.println();

        int[] arr3 = {5,7,7,8,8,10};
        System.out.println(search(arr3, 5)); // 1
        System.out.println(search(arr3, 6)); // 0
        System.out.println(search(arr3, 7)); // 2
        System.out.println(search(arr3, 8)); // 2
    }
}
