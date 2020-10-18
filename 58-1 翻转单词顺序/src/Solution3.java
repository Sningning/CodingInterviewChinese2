/**
 * @author: Song Ningning
 * @date: 2020-07-05 11:33
 */
public class Solution3 {

    /**
     * 也可以使用两个指针 i 和 j，从后往前遍历，按照空格分割单词。
     * 比如："the sky is blue"
     * i 和 j 初始位置指向 e，i 前移，遇到空格，则 [i+1, j] 是一个单词，截取出来存到结果中；
     * 然后 j 指向 s，i 继续前移，如此下去。
     *
     * 如果字符串为："a good   example"，j 指向最后的 e，i 指向 e 前面的空格，但是 i 前面还是空格，
     * 因此 i 需要继续前移，直到走到 d，此时 j 更新为指向 d，i 再继续前移。有一个跳过中间空格的过程。
     */
    public static String reverseWords(String s) {
        s.trim();
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;
        int j = s.length() - 1;
        while (i >= 0) {
            // i 从后往前寻找第一个空格
            while (i >= 0 && s.charAt(i) != ' ') i--;
            // 添加单词
            res.append(s, i + 1, j + 1).append(" ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') i--;
            // j 指向下个单词的尾字符
            j = i;
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = "a good   example";
        System.out.println(reverseWords(s1)); // "blue is sky the"
        System.out.println(reverseWords(s2)); // "world! hello"
        System.out.println(reverseWords(s3)); // "example good a"
    }
}
