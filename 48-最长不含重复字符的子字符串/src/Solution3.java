import java.util.HashMap;

/**
 * @author: Song Ningning
 * @date: 2020-06-27 21:21
 */
public class Solution3 {

    /**
     * 双指针 + 哈希表
     *
     * 但是用队列或数组的话，判断是否含有当前元素的复杂度与队列长度和数组长度有关，我们只是为了寻找到下标，因此可以用哈希表优化查找时间。
     * 哈希表的 key 记录每个字符，value 记录其在 s 中的下标。
     *
     * 用 map 来判重，key 是当前遍历到的字符，value 是当前下标；
     * 用一个 start 变量记录每个无重复子串的起始下标，初始化 start = 0
     * 遍历 s 的每个字符:
     *     如果 map 中不存在该字符，将其放入 map 中，当前无重复子串长度为 end - start + 1；
     *     如果 map 中存在该字符，且下标为 i：
     *         如果 i <= start：则直接更新当前字符对应的 value，不更改 start；
     *         如果 i > start：则首先更新 start 为 i+1，然后更新当前字符对应的 value，确保 [start...end] 没有重复元素
     *
     * 注意：用哈希表时，若 map 中存在当前元素，需要判断 i 与 start 的大小关系。
     * 因为在 map 中查找是在之前所有遍历过的元素中查找，并不是在 [start...end-1] 范围中查找，因此有可能重复元素是在 start 之前出现的，
     * 比如"abba"，遍历到最后一个 a 时，此时 start 指向之前第二个 b，如果不判断大小关系，将 start 更新为 i+1，则 start 会指向
     * 第一个 b，结果 end - start + 1 = 3.
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int res = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(s.lengthOfLongestSubstring(s1)); // 3
        System.out.println(s.lengthOfLongestSubstring(s2)); // 1
        System.out.println(s.lengthOfLongestSubstring(s3)); // 3
    }
}
