/**
 * @Author: Song Ningning
 * @Date: 2020-07-05 15:52
 */
public class Solution2 {

    /**
     * 列表遍历拼接
     * 时间复杂度 O(N)： 线性遍历 s 并添加，使用线性时间；
     * 空间复杂度 O(N)： 新建的辅助 res 使用 O(N) 大小的额外空间。
     */
    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length() - 1; i++)
            res.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    /**
     * 利用求余运算简化上面代码
     */
    public static String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length() + n; i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2)); // "cdefgab"
        System.out.println(reverseLeftWords("lrloseumgh", 6)); // "umghlrlose"
        System.out.println(reverseLeftWords1("abcdefg", 2)); // "cdefgab"
        System.out.println(reverseLeftWords1("lrloseumgh", 6)); // "umghlrlose"
    }
}
