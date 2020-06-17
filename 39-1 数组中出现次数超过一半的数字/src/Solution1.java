import java.util.HashMap;

/**
 * 面试题39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 *
 * 注意：本题与力扣 169 题相同：https://leetcode-cn.com/problems/majority-element/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-17 9:23
 */
public class Solution1 {

    /**
     * 题目说明了数组非空，且一定存在多数元素，因此不用特殊判断。
     * 最简单粗暴的方法是使用哈希表。
     * HashMap 中的 key 存放各个元素，value 存放出现的次数。
     *
     * Time：O(N)
     * Space：O(N)
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) > nums.length / 2)
                return num;
        }
        return -1;
    }

    // public static int majorityElement(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         if (map.containsKey(num))
    //             map.put(num, map.get(num) + 1);
    //         else
    //             map.put(num, 1);
    //         // 边扫描，边判断
    //         if (map.get(num) > nums.length / 2)
    //             return num;
    //     }
    //     return -1;
    // }

    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        System.out.println(majorityElement(arr1));  // 3
        int[] arr2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr2));  // 2
    }
}
