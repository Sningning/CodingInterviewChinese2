import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 * s.length <= 40000
 *
 * 注意：本题与力扣 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-28 9:30
 */
public class Solution1 {

    /**
     * 滑动窗口（队列）
     *
     * 初始化一个队列，保证队列中没有重复元素，队列长度就是实时的无重复子串长度
     * 遍历字符串 s：
     *     如果队列中不包含当前字符 c，则将 c 入队，更新 res；
     *     如果队列中包含当前字符 c，将元素逐个出队，知道重复元素出队，再将 c 入队，更新 res
     *
     * 时间复杂度：O(N^2)，遍历字符串 s 的每一步需要执行队列的 contains 操作，该操作时间复杂度为 O(N)
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
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (queue.contains(s.charAt(i))) {
                char temp = queue.poll();
                while (temp != s.charAt(i)) {
                    temp = queue.poll();
                }
            }
            queue.offer(s.charAt(i));
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(s.lengthOfLongestSubstring(s1)); // 3
        System.out.println(s.lengthOfLongestSubstring(s2)); // 1
        System.out.println(s.lengthOfLongestSubstring(s3)); // 3
    }
}
