/**
 * @Author: Song Ningning
 * @Date: 2020-06-28 22:39
 */
public class Solution3 {

    /**
     * 字符是一个长度为 8 的数据类型，因此总共 256 种可能，因此创建一个长度为 256 的数组当做哈希表。
     * 数组下标作为 ASCII 码值，数组中存储出现的次数。
     */
    public char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        int[] count = new int[256];
        char[] charArr = s.toCharArray();
        for (char c : charArr)
            count[c]++;
        for (char c : charArr) {
            if (count[c] == 1)
                return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "abaccdeff";
        System.out.println(solution3.firstUniqChar(s)); // b
    }
}
