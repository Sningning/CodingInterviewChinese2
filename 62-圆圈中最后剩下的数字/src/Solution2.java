/**
 * @author: Song Ningning
 * @date: 2020-07-16 19:50
 */
public class Solution2 {

    /**
     * 约瑟夫问题的数学解法
     */
    public int lastRemaining(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }
}
