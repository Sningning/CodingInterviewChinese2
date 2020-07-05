/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 注意：此题对比原题有改动
 *
 * @Author: Song Ningning
 * @Date: 2020-07-05 9:58
 */
public class Solution1 {

    /**
     * 使用字符串 api
     *
     * 时间复杂度 O(N)： 总体为线性时间复杂度，各函数时间复杂度和参考资料链接如下。
     * split() 方法：为 O(N)；
     *   参考：https://softwareengineering.stackexchange.com/questions/331909/whats-the-complexity-of-javas-string-split-function
     * trim() 和 strip() 方法：最差情况下（当字符串全为空格时），为 O(N)；
     *   参考：https://stackoverflow.com/questions/51110114/is-string-trim-faster-than-string-replace
     *
     * 空间复杂度 O(N)：单词列表 strArray 占用线性大小的额外空间。
     *
     *
     * Java 中常用的字符串函数：
     *   String demo = "Hello,world!";
     *     1. int length = demo.length(); //获取字符串的长度
     *     2. boolean equals = demo.equals("Hello,world"); // 比较两个字符串相等
     *     3. boolean contains = demo.contains("word"); // 是否包含子串
     *     4. String replace = demo.replace("Hello,", "Yeah@"); // 将指定字符串(或正则表达式)替换，返回替换后的结果
     *     5. char little = demo.charAt(5); // 查找字符串中索引为5的字符（索引从0开始）
     *     6. String trim = demo.trim(); // 将字符串左右空格去除，返回去除空格后的结果
     *     7. String subString = demo.subString(0, 5); // 返回该字符串中索引从 0 到 4 的子串
     *     8. String concat = demo.concat("Great!"); // 拼接字符串，返回拼接结果
     *     9. char[] charArray = demo.toCharArray(); // 返回该字符串组成的字符数组
     *     10. String upperCase = demo.toUpperCase(); // 返回该字符串的大写形式
     *     11.String lowerCase = demo.toLowerCase(); // 返回该字符串的小写形式
     */
    public static String reverseWords(String s) {
        // 删除首尾空格，分割字符串
        String[] strArray = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for (int i = strArray.length - 1; i >= 0; i--) {
            // 防止出现例如："a good   example" 中间多空格的情况
            if (strArray[i].equals("")) continue;
            // 将单词拼接至 StringBuilder
            res.append(strArray[i]).append(" ");
        }
        // 转化为字符串，删除尾部空格，并返回
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
