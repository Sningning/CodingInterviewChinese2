import java.util.Arrays;

/**
 * @Author: Song Ningning
 * @Date: 2020-06-17 9:38
 */
public class Solution2 {
    /**
     * 由于 target 出现的次数超过数组长度的一半，那么如果数组是有序的，中位数一定是 target
     *
     * Time：O(NlogN)
     * Space：O(1)
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        System.out.println(majorityElement(arr1));  // 3
        int[] arr2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr2));  // 2
    }
}
