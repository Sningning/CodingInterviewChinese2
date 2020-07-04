import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @Author: Song Ningning
 * @Date: 2020-05-21 8:27
 */
public class Solution1 {

    /**
     * 暴力法就是固定一个数，然后枚举剩下的数字，依次进行。时间复杂度：O(N)
     *
     * 哈希表
     * Time：O(N)；Space：O(N)
     */
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(target - num))
                return new int[]{target - num, num};
            set.add(num);
        }
        return new int[0];
    }
}
