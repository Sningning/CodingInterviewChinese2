import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Song Ningning
 * @date: 2020-07-04 19:54
 */
public class Solution3 {

    /**
     * 数学方法
     *
     * 因为要找的是【连续正整数序列】，其实是一个等差数列，且公差为 1，根据公式：
     * S = (a + b) * n / 2，其中，a 为首项，b 为末项，n 为项数；
     * 又因为公比为 1，所以根据首项和项数就可以求出末项，化简为：S = na + n*(n-1) / 2；
     * 这里 S 就是 target，即：target = n*a + n*(n-1) / 2；
     *
     * 目标是找出所有满足条件的 n、a 对，
     * 思路是对 n 从 2 开始遍历（题目要求最少是 2 个数），验证 a 是否为正整数。
     * 有一个问题是 n 遍历到多少呢？
     * 其实不需要特地去算 n 的上限，因为随着 n 的递增，a 递减，当 a <= 0 时跳出循环即可。
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();
        for (int n = 2; n < target; n++) {
            int temp = target - n * (n - 1) / 2;
            if (temp < n) {
                // 如果 temp < n 了，后面求 a = temp / n，a 肯定为 0，直接 break
                break;
            }
            if ((temp % n) == 0) {
                int a = temp / n;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = a + i;
                }
                list.add(arr);
            }
        }
        int[][] res = new int[list.size()][];
        // 要求：序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
        // 但加入的时候 n 是从小还是加入，正好相反了，要将 list 中顺序颠倒
        Collections.reverse(list);
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
