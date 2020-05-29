/**
 * @Author: Song Ningning
 * @Date: 2020-05-29 0:39
 */
public class Solution4 {

    // 贪心
    // Time：O(N)
    // Space：O(1)
    public static int cuttingRope(int n) {
        // 因为必须要分割，因此必须分成 1 * (n - 1)
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // 4 分解成 2*2
        if (n == 4) {
            return 4;
        }

        // 尽可能分成 3
        int res = 1;
        while (n >= 5) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));  // 36
        System.out.println(cuttingRope(31));  // 78732
    }
}
