import java.util.LinkedHashMap;

/**
 * @author: Song Ningning
 * @date: 2020-06-28 21:53
 */
public class Solution2 {

    /**
     * 有序哈希表
     * 方法一中第二次遍历字符串是为了找到第一个 value 为 true 的字符，如果使用有序哈希表只需要遍历一遍字符串，
     * 再遍历一遍哈希表，就可以找到答案，由于哈希表是去重的，因此长度是小于字符串长度的。
     *
     * Java 中 LinkedHashMap 可以维护插入的顺序
     */
    public char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) map.put(c, false);
            else map.put(c, true);
        }
        for (char c : map.keySet()) {
            if (map.get(c)) return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "abaccdeff";
        System.out.println(solution2.firstUniqChar(s)); // b
    }
}
