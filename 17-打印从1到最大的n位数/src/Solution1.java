/**
 * 力扣改过的题目：
 *
 * 面试题17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]

 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * @author: Song Ningning
 * @date: 2020-05-30 10:20
 */
public class Solution1 {

    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n);
        int[] res = new int[max - 1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
