/**
 * @author: Song Ningning
 * @date: 2020-07-31 19:50
 */
public class Solution2 {

    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        double res = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 7));
    }
}
