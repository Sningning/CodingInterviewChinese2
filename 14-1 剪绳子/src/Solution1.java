/**
 * 面试题14-I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 *
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 提示：
 * 2 <= n <= 58
 *
 * 本题与力扣 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * @author: Song Ningning
 * @date: 2020-05-28 12:46
 */
public class Solution1 {

    // 暴力递归
    // 超时
    public static int cuttingRope(int n) {
        if (n == 1) {
            return 1;
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cuttingRope(n - i)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));  // 36
    }
}
