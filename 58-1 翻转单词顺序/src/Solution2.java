import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Song Ningning
 * @date: 2020-07-05 10:37
 */
public class Solution2 {

    /**
     * 因为是倒序，可以想到用栈
     * 扫描字符串 s，遇到一个单词就压入栈中，最后依次弹出。
     * 确定单词边界就是靠空格，但是最后一个单词后面可能没有空格，所以可以人为添加一个。
     */
    public static String reverseWords(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder temp = new StringBuilder();
        s += " ";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                // 如果当前是空格且 temp 长度不为空，说明已经构成一个单词
                // 需要添加到结果中，并重置 temp
                if (temp.length() != 0) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                // 如果当前不是空格，将其添加到 temp 中
                temp.append(c);
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop()).append(" ");
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
