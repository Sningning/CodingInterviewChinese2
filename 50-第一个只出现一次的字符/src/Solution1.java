import java.util.HashMap;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 限制：
 * 0 <= s 的长度 <= 50000
 *
 * @Author: Song Ningning
 * @Date: 2020-06-28 21:29
 */
public class Solution1 {

    /**
     * 哈希表
     *
     * 首先遍历 s，使用哈希表统计 “各字符数量是 1 ”
     * 再遍历一遍 s，在哈希表中找到第一个出现次数为 1 的字符.
     *
     * map 的 value 存储 boolean 类型，可以用来判断，从而简化代码逻辑
     *
     * 时间复杂度：O(2N)，需遍历 s 两轮
     * 空间复杂度：O(N)
     */
    public char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            if (map.containsKey(c)) map.put(c, false);
            else map.put(c, true);
        }
        for (char c : charArr) {
            if (map.get(c)) return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = "abaccdeff";
        System.out.println(solution1.firstUniqChar(s)); // b
    }
}
