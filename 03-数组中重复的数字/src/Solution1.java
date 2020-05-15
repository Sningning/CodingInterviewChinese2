import java.util.HashSet;

/**
 * 面试题03. 数组中重复的数字
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @Author: Song Ningning
 * @Date: 2020-05-15 21:01
 */
public class Solution1 {

    public int findRepeatNumber(int[] nums) {

        // 哈希表
        // Time：O(N)；Space：O(N)

        if (nums.length == 0)
            return -1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
    }
}
