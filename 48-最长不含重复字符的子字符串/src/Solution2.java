/**
 * @author: Song Ningning
 * @date: 2020-06-28 9:57
 */
public class Solution2 {

    /**
     * 使用两个指针 start 和 end，分别记录无重复子串的起始位置和结束位置
     *
     * 依次查看每个元素，判断在 [start...end-1] 范围是否存在当前元素：
     * 如果不存在当前元素，则检查下一个元素即可，当前无重复子串的长度为 end-start+1；
     * 如果存在当前元素，且下标为 i，则先将 start 更新为 i+1，当前无重复子串的长度为 end-start+1
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int res = 0;
        int start = 0, end = 1;
        for (end = 1; end < s.length(); end++) {
            // 在之前的无重复子串中查找是否存在当前元素
            for (int i = start; i < end; i++) {
                // 如果存在，需要将字串起始字符向后移动一个
                if (s.charAt(i) == s.charAt(end)) {
                    start = i + 1;
                    break;
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(s.lengthOfLongestSubstring(s1)); // 3
        System.out.println(s.lengthOfLongestSubstring(s2)); // 1
        System.out.println(s.lengthOfLongestSubstring(s3)); // 3
    }
}
