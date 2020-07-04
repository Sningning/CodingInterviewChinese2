import java.util.HashMap;

/**
 * 645. 错误的集合
 * 集合 S 包含从 1 到 n 的整数。
 * 不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 * 注意:
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 *
 * @Author: Song Ningning
 * @Date: 2020-07-03 23:44
 */
public class Solution1 {

    /**
     * 哈希表
     * 扫描数组，将数字与出现的次数记录下来；
     * 从 1 到 n 开始判断，如果某个数字在哈希表中出现两次，则是重复数字，如果一次也没出现，则是消失的数字。
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int[] findErrorNums(int[] nums) {
        int dup = 1;
        int missing = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                missing = i;
            }
        }
        return new int[]{dup, missing};
    }
}
