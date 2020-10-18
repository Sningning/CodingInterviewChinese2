/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author: Song Ningning
 * @date: 2020-05-15 22:29
 */
public class Solution {

    public static String replaceSpace(String s) {

        // 循环，使用一个辅助 StringBuilder
        // Time：O(N)；Space：O(N)

        if (s.length() == 0)
            return s;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                res.append("%20");
            else
                res.append(c);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
