/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0～n-1 之内。
 * 在范围 0～n-1 内的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 限制：
 * 1 <= 数组长度 <= 10000
 *
 * @Author: Song Ningning
 * @Date: 2020-06-30 11:21
 */
public class Solution {

    /**
     * n 个数放到长度为 n 的数组中，且从 0 依次加一，如果不缺失，则 index = nums[index]。
     * 如果有且只有一个数字 m 缺失，则从 m 位置的数字为 m+1，m+1 位置的数为 m+2，因此，m
     * 刚好是第一个数值与下标不同的数。
     *
     * 数组可以按照以下规则划分为两部分。
     * 左子数组：nums[i] = i；
     * 右子数组：nums[i] != i；
     *
     * 缺失的数字等于 “右子数组的首位元素” 对应的索引
     *
     * 时间复杂度：O(logN)，二分法为对数级别复杂度。
     * 空间复杂度：O(1)，几个变量使用常数大小的额外空间。
     */


    /**
     * 最后返回时应该要讨论：
     * 如果剩下的 3 个数分别为 3 5 6，此时 left 指向 3，mid 指向 5，right 指向 6，
     *     由于 mid != nums[mid]，right 左移指向 3，退出循环，此时缺失的数是 left + 1 = 4；
     * 如果剩下的 3 个数分别为 3 4 6，此时 left 指向 3，mid 指向 4，right 指向 6，
     *     由于 mid == nums[mid]，left 右移指向 6，退出循环，此时缺失的数是 left = 5；
     */
    static class Solution1 {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + ((right - left) >>> 1);
                if (mid == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left == nums[left] ? left + 1 : left;
        }

        public static void main(String[] args) {
            Solution1 s = new Solution1();
            int[] arr1 = {0};
            int[] arr2 = {1};
            int[] arr3 = {0, 1, 2, 4, 5};
            int[] arr4 = {0, 2, 3, 4, 5};
            System.out.println(s.missingNumber(arr1)); // 1
            System.out.println(s.missingNumber(arr2)); // 0
            System.out.println(s.missingNumber(arr3)); // 3
            System.out.println(s.missingNumber(arr4)); // 1
        }
    }


    /**
     * 另一种写法
     * while 循环中写成 left <= right，最后 left 指向右子数组第一个，right 指向左子数组最后一个。
     */
    static class Solution2 {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >>> 1);
                if (mid == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public static void main(String[] args) {
            Solution2 s = new Solution2();
            int[] arr1 = {0};
            int[] arr2 = {1};
            int[] arr3 = {0, 1, 2, 4, 5};
            int[] arr4 = {0, 2, 3, 4, 5};
            System.out.println(s.missingNumber(arr1)); // 1
            System.out.println(s.missingNumber(arr2)); // 0
            System.out.println(s.missingNumber(arr3)); // 3
            System.out.println(s.missingNumber(arr4)); // 1
        }
    }

}
