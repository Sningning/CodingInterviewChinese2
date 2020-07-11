import java.util.Arrays;
import java.util.HashSet;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13]
 *
 * @author: Song Ningning
 * @date: 2020-07-11 9:24
 */
public class Solution2 {

    /**
     * 哈希表
     *
     * 可以遍历数组元素，利用哈希表判重，遍历完之后就可以知道最大最小值。
     *
     * 时间复杂度：O(N) = O(5) = O(1)
     * 空间复杂度：O(N) = O(5) = O(1)
     */
    public boolean isStraight(int[] nums) {
        int max = 1;
        int min = 13;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) { // 跳过大小王
                continue;
            }
            if (set.contains(num)) { // 判断有无重复
                return false;
            }
            max = Math.max(max, num); // 记录最大牌
            min = Math.min(min, num); // 记录最小牌
            set.add(num);
        }
        return max - min < 5;
    }
}
