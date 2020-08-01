/**
 * @author: Song Ningning
 * @date: 2020-08-01 10:26
 */
public class Solution5 {

    /**
     * 如果需要保证元素顺序，可以使用辅助数组和双指针
     * start 指向奇数从前往后待插入的位置，end 指向偶数从后往前待插入的位置
     *
     */
    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] aux = new int[len];
        int start = 0, end = len - 1;
        int lo = 0, hi = len - 1;
        while ((lo < len) && (hi >= 0)) {
            if ((nums[lo] & 1) == 1) {
                aux[start++] = nums[lo];
            }
            if ((nums[hi] & 1) == 0) {
                aux[end--] = nums[hi];
            }
            lo++;
            hi--;
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

        System.out.println();

        int[] arr5 = {2,16,3,5};
        for (int num : exchange(arr5))
            System.out.print(num + " ");

    }
}
