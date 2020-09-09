/**
 * @author: Song Ningning
 * @date: 2020-06-02 19:46
 */
public class Solution2 {

    public static int[] exchange(int[] nums) {

        /*
         * 双指针
         * 考虑定义双指针 left, right 分列数组左右两端，循环执行：
         * 指针 left 从左向右寻找偶数；
         * 指针 right 从右向左寻找奇数；
         * 将 偶数 nums[left] 和 奇数 nums[right] 交换。
         * 可始终保证： 指针 left 左边都是奇数，指针 right 右边都是偶数 。
         *
         * Time：O(N)
         * Space：O(1)
         */
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (left < right) {
            while ((left < right) && (nums[left] & 1) == 1) left++;
            while ((left < right) && (nums[right] & 1) == 0) right--;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
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
    }
}
