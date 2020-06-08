import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 提示：
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 * 注意：本题与力扣 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-08 21:55
 */
public class Solution {

    /*
     * 辅助栈
     * 将压入序列中的数字入栈，然后按照出栈序列中的数字出栈。
     * 比如：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 遍历 pushed 序列，将元素依次压入辅助栈，然后【循环判断】栈顶元素与 popped 序列中当前考虑的元素：
     *     如果辅助栈栈顶元素 == popped 中当前考虑的元素：辅助栈弹出栈顶元素，考虑 popped 下一个元素
     *     如果辅助栈栈顶元素 != popped 中当前考虑的元素：继续从 pushed 栈中取出元素压入辅助栈
     * 最后看辅助栈是否为空，空的话说明是合法的序列。
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // 提示中说明了 pushed 和 popped 的大小是相等的
        // 其中一个长度为 0，另一个一定也为 0，按照要求都为空数组的话返回 true
        if (pushed.length == 0)
            return true;
        Deque<Integer> stack = new LinkedList<>();
        // 记录 popped 栈的索引
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped1 = {4,5,3,2,1};
        int[] popped2 = {4,3,5,1,2};
        System.out.println(validateStackSequences(pushed, popped1));
        System.out.println(validateStackSequences(pushed, popped2));
    }
}
