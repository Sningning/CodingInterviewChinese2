/**
 * @Author: Song Ningning
 * @Date: 2020-06-17 10:22
 */
public class Solution3 {

    /**
     * 摩尔投票法
     *
     * Time：O(N)
     * Space：O(1)
     */
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                count = candidate == nums[i] ? count + 1 : count - 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        System.out.println(majorityElement(arr1));  // 3
        int[] arr2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr2));  // 2
    }
}
