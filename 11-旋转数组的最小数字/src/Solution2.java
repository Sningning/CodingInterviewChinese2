/**
 * @Author: Song Ningning
 * @Date: 2020-05-18 22:02
 */
public class Solution2 {
    public int minArray(int[] numbers) {

        // 2. 二分
        // Time：O(logN)；Space：O(1)

        // 1.为什么要用nums[mid]和nums[right]比较，而不是和nums[left]比较。
        // 因为是寻找最小值，看如下例子：
        // [1,2,3,4,5][1,2,3,4,5]
        // [2,3,4,5,1][2,3,4,5,1]
        // 虽然nums[mid]都大于nums[left]，但是最小值可以在左侧或者右侧。

        // 2.在nums[mid]==nums[right]，为什么令 right = right - 1？
        // 例子：[1,1,1,3,1]
        // 假设nums[right]是最小值，有两种情况：
        // 若 nums[right]是唯一最小值：则不能满足判断条件 nums[mid] == nums[right]；
        // 若 nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，
        // 即还有最小值存在于 [left, right - 1]区间，因此不会丢失最小值。

        int len = numbers.length;
        if (len == 0)
            return 0;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            // 如果 中间 小于 最右边，肯定不在右边
            if (numbers[mid] < numbers[right]) right = mid;
            // 如果 中间 大于 最右边，肯定不在左边
            else if (numbers[mid] > numbers[right]) left = mid + 1;
            else if (numbers[mid] == numbers[right]) right--;
        }
        return numbers[left];
    }
}