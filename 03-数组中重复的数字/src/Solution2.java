import java.util.Arrays;

/**
 * @author: Song Ningning
 * @date: 2020-05-15 21:15
 */
public class Solution2 {

    public int findRepeatNumber(int[] nums) {

        // 排序
        // Time：O(NlogN)；Space：O(1)

        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return -1;
    }
}
