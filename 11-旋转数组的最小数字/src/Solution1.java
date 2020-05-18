/**
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * @Author: Song Ningning
 * @Date: 2020-05-18 18:17
 */
public class Solution1 {

    public static int minArray(int[] numbers) {

        // 1. 暴力
        // Time：O(N)；Space：O(1)

        int res = Integer.MAX_VALUE;
        for (int number : numbers)
            res = Math.min(res, number);
        return res;
    }

}
