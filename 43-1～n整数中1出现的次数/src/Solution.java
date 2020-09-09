/**
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 *
 * 限制：
 * 1 <= n < 2^31
 *
 * 注意：本题与力扣 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 *
 * 视频讲解：https://www.bilibili.com/video/BV1uJ411573j?from=search&seid=17043492097021581454
 *
 * @author: Song Ningning
 * @date: 2020-06-22 8:46
 */
public class Solution {

    /**
     *     high     low
     *    3456【cur】78
     *
     *    情况 1：high 取值范围：[0...3455]，即从 0 到 high-1，此时 low 的取值范围可以是：[0...99]，即从 0 到 low 的数位的最大值，
     *           这种情况下，出现 1 的次数为：3455 * 100；
     *    情况 2：high 取 3456，此时要看 cur 与 1 的大小：
     *           如果 cur == 1，则 low 的取值范围为：[0...78]，即从 0 到 low，出现 1 的次数为：1 * 78；
     *           如果 cur > 1，则 low 的取值范围为：[0...99]，即从 0 到 low 的数位的最大值，出现 1 的次数为：1 * 100；
     *           如果 cur < 1，即 cur == 0，则无法满足要求。
     *   对于整数 n，从低位往高位依次考虑。
     */
    public int countDigitOne(int n) {
        int res = 0;
        if (n <= 0) {
            return res;
        }
        int index = 1;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            // 情况 1
            res += high * index;
            // 情况 2：
            if (cur == 1) {
                res += low + 1;
            } else if (cur > 1) {
                res += index;
            }
            // 开始下一位判断
            low += cur * index;
            cur = high % 10;
            high /= 10;
            index *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countDigitOne(12)); // 5
        System.out.println(s.countDigitOne(13)); // 6
        System.out.println(s.countDigitOne(824883294)); // 767944060
    }
}
