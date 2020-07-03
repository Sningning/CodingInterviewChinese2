import java.util.HashMap;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * https://leetcode-cn.com/problems/single-number/
 *
 * @Author: Song Ningning
 * @Date: 2020-07-03 20:33
 */
public class Solution1 {

    /**
     * 哈希表
     *
     * 最傻白甜的方法是使用哈希表，遍历数组，标记只出现一次的元素，再遍历一遍哈希表，找到该元素返回。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, false);
            } else {
                map.put(num, true);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
