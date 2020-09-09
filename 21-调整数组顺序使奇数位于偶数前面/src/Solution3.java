/**
 * @author: Song Ningning
 * @date: 2020-06-02 19:46
 */
public class Solution3 {

    public static int[] exchange(int[] nums) {

        /*
         * 如果把题目改成所有负数在非负数前面，或者能被 3 整除的放在前面，不能被 3 整除的放在后面。
         * 我们只需要将内层 while 判断条件的后半部分抽取成一个函数即可，程序基本框架是不需要修改的。
         */
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (left < right) {
            while ((left < right) && fun(nums[left])) left++;
            while ((left < right) && !fun(nums[right])) right--;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    // 抽取出来的判断条件
    public static boolean fun(int num) {
        return (num & 1) == 1;
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
