/**
 * @Author: Song Ningning
 * @Date: 2020-06-27 19:18
 */
public class Solution3 {

    /**
     * 对于 num，从左往右看和从右往左看最终效果都是一样的。
     * 因此也可以从左往右看。
     * 从右往左看的话就可以利用求余运算 num % 10 和求整运算 num / 10，获取每一位的数字。
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        // b = dp[len-1]; c = dp[len];
        int b = 1, c = 1;
        int a;
        int cur; // 当前考虑的数字
        int next = num % 10; // 当前数字的下一位数字（即 前一步考虑过的数字）
        while (num != 0) {
            num /= 10;
            cur = num % 10;
            if (cur == 1 || (cur == 2 && next < 6)) {
                a = b + c;
            } else {
                a = b;
            }
            next = cur;
            c = b;
            b = a;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.translateNum(12258)); // 5
    }
}
