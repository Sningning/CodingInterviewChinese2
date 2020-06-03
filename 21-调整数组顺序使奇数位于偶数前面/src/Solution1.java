/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * @Author: Song Ningning
 * @Date: 2020-06-02 19:46
 */
public class Solution1 {

    public static int[] exchange(int[] nums) {

        /*
         * 辅助数组，遍历原数组，遇到奇数放到辅助数组开头，遇到偶数放到辅助数组最后
         *
         * Time：O(N)
         * Space：O(N)
         */
        int[] aux = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int num : nums) {
            if ((num & 1) == 1)
                aux[i++] = num;
            else
                aux[j--] = num;
        }
        return aux;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1,1,1};
        for (int num : exchange(arr1))
            System.out.print(num + " ");

        System.out.println();

        int[] arr2 = {2,4,6,8};
        for (int num : exchange(arr2))
            System.out.print(num + " ");

        System.out.println();

        int[] arr3 = {};
        for (int num : exchange(arr3))
            System.out.print(num + " ");

        System.out.println();

        int[] arr4 = {1,2,3,4};
        for (int num : exchange(arr4))
            System.out.print(num + " ");
    }
}
