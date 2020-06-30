/**
 * @Author: Song Ningning
 * @Date: 2020-06-30 15:43
 */
public class Solution2 {

    /**
     *
     */
    public int search(int[] nums, int target) {
        return 0;
    }


    private static int helper(int[] nums, int target) {
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
        int[] arr = {1,2,2,3,3,4,5};
        System.out.println(helper(arr, 6)); // 7
        System.out.println(helper(arr, 0)); // 0
        System.out.println(helper(arr, 3)); // 5
    }
}
