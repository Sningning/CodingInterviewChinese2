import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。

 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * 注意：本题与力扣 47 题相同：https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author: Song Ningning
 * @date: 2020-06-16 11:01
 */
public class Solution {

    List<String> list = new ArrayList<>();
    boolean[] used;

    public String[] permutation(String s) {
        if (s.length() == 0)
            return new String[0];
        // 先转换为字符数组
        char[] ch = s.toCharArray();
        // 排序，方便去重
        Arrays.sort(ch);
        used = new boolean[ch.length];
        StringBuilder path = new StringBuilder();
        backtrack(ch, path, 0, used);
        int len = list.size();
        String[] res = new String[len];
        // 集合转数组
        list.toArray(res);
        return res;
    }

    private void backtrack(char[] ch, StringBuilder path, int index, boolean[] used) {
        if (index >= ch.length) {
            list.add(new String(path.toString()));
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            // 去重剪枝
            if (i > 0 && ch[i] == ch[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.append(ch[i]);
                backtrack(ch, path, index + 1, used);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
