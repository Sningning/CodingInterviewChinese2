import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author: Song Ningning
 * @date: 2020-06-18 17:24
 */
public class Solution1 {

    /**
     * 暴力
     * 先排序，找到从后往前数第 k 个元素(最后一个是第一个)，也就是索引为 len-k 位置元素
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr1 = {3,2,1,5,6,4};
        int[] arr2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(s.findKthLargest(arr1, 2)); // 5
        System.out.println(s.findKthLargest(arr2, 4)); // 4

    }
}
