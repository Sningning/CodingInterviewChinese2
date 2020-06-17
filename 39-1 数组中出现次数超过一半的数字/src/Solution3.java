/**
 * @Author: Song Ningning
 * @Date: 2020-06-17 10:22
 */
public class Solution3 {

    /**
     * 摩尔投票法
     * 候选人的票数不一定能超过一半，例如 [A, B, C]的抵消阶段，最后得到的结果是 [C,1]，C候选人的票数也未能超过一半的票数。
     * 但是题目中限定了该元素一定存在，所以最后的候选人一定是众数。
     * 如果没有限定一定存在的话，除投票外，还需要计数。
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
