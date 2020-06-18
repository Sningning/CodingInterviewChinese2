/**
 * @Author: Song Ningning
 * @Date: 2020-06-18 17:39
 */
public class Solution3 {
    /**
     * 快速选择
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickSelect(nums, 0, len - 1, len - k);
        return nums[len - k];
    }

    private void quickSelect(int[] nums, int lo, int hi, int index) {
        int j = partition(nums, lo, hi);
        if (j == index) {
            return;
        } else if (j < index) {
            quickSelect(nums, j + 1, hi, index);
        } else { // j > index
            quickSelect(nums, lo, j - 1, index);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        // 随机初始化 pivot 元素
        swap(nums, lo, (int) (Math.random() * (hi - lo + 1)) + lo);
        int p = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < p);
            while (--j >= lo && nums[j] > p);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int[] arr1 = {3,2,1,5,6,4};
        int[] arr2 = {3,2,3,1,2,4,5,5,6};
        int[] arr3 = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6,1};
        System.out.println(s.findKthLargest(arr1, 2)); // 5
        System.out.println(s.findKthLargest(arr2, 4)); // 4
        System.out.println(s.findKthLargest(arr3, 1)); // 11
    }
}
