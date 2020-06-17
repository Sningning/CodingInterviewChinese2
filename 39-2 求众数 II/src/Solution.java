import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 [ n/3 ] 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: [3]
 *
 * 示例 2:
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * https://leetcode-cn.com/problems/majority-element-ii/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-17 10:49
 */
public class Solution {

    /**
     * 要求空间复杂度为 O(1)，因此不能使用哈希表。
     *
     * 摩尔投票法
     * 等于 [ n/3 ] 次的元素个数最多有 3 个，而超过 [ n/3 ] 次的元素最多可能出现 2 个。
     */
    public static List<Integer> majorityElement(int[] nums) {

        LinkedList<Integer> res = new LinkedList<>();
        // 特判
        if (nums == null || nums.length == 0)
            return res;
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;
        // 投票阶段
        // 初始化：定义两个候选人和各自的票数
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            } else if (countA == 0) {
                candidateA = num;
                countA = 1;
            } else if (countB == 0) {
                candidateB = num;
                countB = 1;
            } else {
                countA--;
                countB--;
            }
        }
        // 计数阶段
        // 上一轮遍历找出了两个候选人，但是这两个候选人是否均满足票数大于N/3仍然没法确定，需要重新遍历，确定票数
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (candidateA == num)
                countA++;
            else if (candidateB == num)
                countB++;
        }
        if (countA > nums.length / 3)
            res.add(candidateA);
        if (countB > nums.length / 3)
            res.add(candidateB);
        return res;
    }


    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        int[] arr2 = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(arr1));  // [3]
        System.out.println(majorityElement(arr2));  // [1, 2]
    }
}
