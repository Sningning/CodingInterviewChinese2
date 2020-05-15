/**
 * @Author: Song Ningning
 * @Date: 2020-05-15 21:23
 */
public class Solution3 {

    public int findRepeatNumber(int[] nums) {

        // 原地置换（相当于边排序边判断）
        // Time：O(N)；Space：O(1)
        // 长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内,
        // 数组的元素值的范围恰好和数组的长度是一样的
        // 如果没有重复的话，nums[i] 应该放在 i 位置，即下标与元素相同
        // 遍历数组：检查当前元素是否在正确位置，是的话循环继续；
        //         否则：下标 i 的元素 nums[i]，如果 == nums[nums[i]],找到了重复元素，返回;
        //              如果 nums[i] != nums[nums[i]]，交换两个元素位置，继续判断 i 位置

        if (nums.length == 0)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前的数 nums[i] 没有在下标为 i 的位置上，就把它交换到下标 i 上
            // 交换过来的数还得做相同的操作，因此这里使用 while
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
