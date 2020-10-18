/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以 0123456789101112131415… 的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 *
 * 限制：
 *
 * 0 <= n < 2^31
 *
 * 注意：本题与力扣 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 *
 * @author: Song Ningning
 * @date: 2020-06-23 9:07
 */
public class Solution {

    /**
     * 找规律
     *
     *       数字范围       位数       数字个数           数字总位数
     *       1 ~ 9         1         9 * 1            9 * 1 * 1
     *      10 ~ 99        2         9 * 10           9 * 10  * 2
     *     100 ~ 99        3         9 * 100          9 * 100 * 3
     *    1000 ~ 9999      4         9 * 1000         9 * 1000 * 4
     *   start ~ end     digit      9 * start         9 * start * digit
     *
     *  对于第 n 位对应的数字，令这个数字对应的数为 num，然后分三步进行：
     *  ① 找到这个数字对应的数是几位数，用 digit 表示；
     *  ② 确定对应的数的数值 num；
     *  ③ 确定返回值是 num 中的哪个数字。
     *
     *  比如：输入 n 为 365
     *  ① 找到这个数字对应的数是几位数：365 - (9 * 1) - (90 * 2) = 176 < (900 * 3)，所以 num 是一个 3 位数；
     *  ② 确定对应的数的数值 num：
     *      找到 num 在所在范围里是第几个数（从 0 算）：176 / 3 = 58，说明 num 可能是第 57 个数或第 58 个数（从 0 算），
     *      即 157 或 158，又由于 176 % 3 = 2，故 num = 158；
     *  ③ 确定返回值是 num 中的哪个数字：176 % 3 = 2，则为 158 的第二位数字：5
     *
     */
    public int findNthDigit(int n) {
        if (n < 0){
            return -1;
        }
        if (n < 10) {
            return n;
        }
        // 用 int 会溢出
        // 计算该数字由几位数字组成，由1位：digits = 1；2位：digits = 2...
        long start = 1, digit = 1, count = 9;
        while (n - count > 0) {
            n -= count;
            start *= 10;
            digit += 1;
            count = 9 * start * digit;
        }
        // 计算真实代表的数字是多少
        long num = start + (n / digit - 1);
        long index = n % digit;
        if (index == 0) {
            return (int) (num % 10);
        }
        num += 1;
        // 从真实的数字中找到想要的那个数字
        for (long i = index; i < digit; i++) {
            num /= 10;
        }
        return (int) (num % 10);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNthDigit(365)); // 5
        System.out.println(s.findNthDigit(1000000000)); // 1
    }
}
