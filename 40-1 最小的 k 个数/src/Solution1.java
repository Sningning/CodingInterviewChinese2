import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @author: Song Ningning
 * @date: 2020-06-18 11:09
 */
public class Solution1 {

    /**
     * 内置 sort 函数
     * 这种方法虽然解法并不能让人满意，但是最简单，并且能保证正确性，可以作为检验其他方法的标准。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0)
            return new int[0];
        if (arr.length <= k)
            return arr;
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = arr[i];
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr1 = {3,2,1};
        int[] arr2 = {0,1,2,1};
        int[] res1 = s.getLeastNumbers(arr1, 2);
        for (int num : res1) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] res2 = s.getLeastNumbers(arr2, 2);
        for (int num : res2) {
            System.out.print(num + " ");
        }
    }
}
