/**
 * @Author: Song Ningning
 * @Date: 2020-05-29 0:39
 */
public class Solution4 {

    // 贪心
    // Time：O(N)
    // Space：O(1)
    public static int cuttingRope(int n) {
        // 因为至少要分割一次，2 和 3 只能拆分成 1 * (n - 1)
        if (n <= 3) {
            return n - 1;
        }
        int res = 1;
        if (n % 3 == 1) {
            // 如果 mod 3 余 1，先分出一个 4
            res *= 4;
            n -= 4;
        } else if (n % 3 == 2) {
            // 如果 mod 3 余 2，先分出一个 2
            res *= 2;
            n -= 2;
        }
        while (n != 0) {
            // 剩下的都拆分成 3
            res *= 3;
            n -= 3;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));  // 36
        System.out.println(cuttingRope(31));  // 78732
    }
}
