/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * @author: Song Ningning
 * @date: 2020-06-29 8:29
 */
public class Solution {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return sortProcess(nums, 0, nums.length - 1);
    }

    private int sortProcess(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + ((r - l) >>> 1);
        int left = merge(nums, l, mid, r);
        int right = sortProcess(nums, mid + 1, r);
        // 如果已经有序了，当前不需要归并，不存在逆序对
        if (nums[mid] <= nums[mid + 1]) {
            return left + right;
        }
        return merge(nums, l, mid, r) + left + right;
    }

    private int merge(int[] nums, int l, int m, int r) {
        int[] aux = new int[r - l + 1];
        int p1 = l, p2 = m + 1, p = 0;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            // 当 nums[p1] > nums[p2] 时，nums[p2] 需要填到辅助数组
            // 此时，nums[p1..m] 范围的数都是严格大于 nums[p2]
            res += nums[p1] > nums[p2] ? (m - p1 + 1) : 0;
            aux[p++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= m) {
            aux[p++] = nums[p1++];
        }
        while (p2 <= r) {
            aux[p++] = nums[p2++];
        }
        if (aux.length >= 0) {
            System.arraycopy(aux, 0, nums, l, aux.length);
        }
        return res;
    }
}
