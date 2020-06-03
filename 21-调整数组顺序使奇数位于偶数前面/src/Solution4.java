/**
 * 如果题目要求不改变原来数字的顺序
 *
 * @Author: Song Ningning
 * @Date: 2020-06-02 19:46
 */
public class Solution4 {

    public static int[] exchange(int[] nums) {

        /*
         * 如果题目要求不改变原来数字的顺序，可以参考插入排序思路。
         * 指针 i 扫描数组：
         *     if 当前为奇数：i++;
         *     if 当前为偶数：j = i + 1, j 往后扫描
         *         if j 扫描到的为偶数：j++;
         *         if j 扫描到的为奇数：记录当前奇数 k，将[i, j-1] 元素后移一位。
         *
         * Time：O(N^2)
         * Space：O(1)
         */
        int i = 0;
        int j;
        int temp;
        while (i < nums.length) {
            if ((nums[i] & 1) == 1) {
                i++;
            }
            else {
                j = i + 1;
                while (j < nums.length && (nums[j] & 1) == 0) j++;
                if (j >= nums.length)
                    break;
                temp = nums[j];
                for (int k = j - 1; k >= i; k--) {
                    nums[k + 1] = nums[k];
                }
                nums[i] = temp;
            }
        }
        return nums;
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

        System.out.println();

        int[] arr5 = {2,16,3,5};
        for (int num : exchange(arr5))
            System.out.print(num + " ");

    }
}
