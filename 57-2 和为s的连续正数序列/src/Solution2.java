import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Song Ningning
 * @Date: 2020-07-04 19:36
 */
public class Solution2 {

    /**
     * 滑动窗口（双指针）
     */
    public static int[][] findContinuousSequence(int target) {
        
        List<int[]> list = new LinkedList<>();
        int left = 1; // 滑动窗口的左边界
        int right = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        while (left <= target / 2) {
            if (sum < target) {
                // 若和小于目标，右指针向右移动，扩大窗口
                sum += right;
                right++;
            } else if (sum > target) {
                // 若和大于目标，左指针向右移动，减小窗口
                sum -= left;
                left++;
            } else { // sum < target
                // 存结果
                int[] arr = new int[right - left]; // 注意范围
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                list.add(arr);
                // 还要继续扩大寻找下一个可能的窗口
                sum -= left;
                left++;
            }
        }
        int[][] res = new int[list.size()][];
        list.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] arr1 = findContinuousSequence(9);
        int[][] arr2 = findContinuousSequence(15);
        for (int[] ints : arr1) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int[] ints : arr2) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
