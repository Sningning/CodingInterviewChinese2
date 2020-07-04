import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 限制：
 * 1 <= target <= 10^5
 *
 * @Author: Song Ningning
 * @Date: 2020-07-04 18:40
 */
public class Solution1 {

    /**
     * 暴力枚举，两层循环
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();
        for (int i = 1; i <= target / 2; i++) {
            int sum = i;
            // 如果当前数字已经大于等于 target 了，直接 break
            if (sum >= target) {
                break;
            }
            for (int j = i + 1; ; j++) {
                sum += j;
                if (sum == target) {
                    int[] arr = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        arr[k - i] = k;
                    }
                    list.add(arr);
                    break;
                } else if (sum > target) {
                    break;
                }
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
