/**
 * @Author: Song Ningning
 * @Date: 2020-07-05 16:07
 */
public class Solution3 {

    /**
     * 三次翻转
     * 假如给出示例输入 "a b c d e f g", k=2,处理方法如下:
     * ① 将字符串下标 0 ~ k-1 的字符翻转："b a c d e f g"；
     * ② 将字符串下标 k ~ len-1 的字符翻转："b a g f e d c"
     * ③ 将字符串整体翻转："c d e f g a b"
     */
    public static String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder res = new StringBuilder(s);
        reverse(res, 0, n - 1);
        reverse(res, n, len - 1);
        reverse(res, 0, len - 1);
        return res.toString();
    }

    private static void reverse(StringBuilder builder, int left, int right) {
        char temp;
        while (left < right) {
            temp = builder.charAt(left);
            builder.setCharAt(left++, builder.charAt(right));
            builder.setCharAt(right--, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2)); // "cdefgab"
        System.out.println(reverseLeftWords("lrloseumgh", 6)); // "umghlrlose"
    }
}
