import java.util.LinkedList;
/**
 * @Author: Song Ningning
 * @Date: 2020-05-15 22:49
 */
public class Solution2 {

    // 递归
    // Time：O(N)；Space：O(N)
    // 这里“打印”输出的位置是在递归方法返回以后，类似于“回溯算法”中“状态重置”的位置。

    LinkedList<Integer> list = new LinkedList<>();

    public int[] reversePrint(ListNode head) {

        print(head);

        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.poll();
        }
        return res;
    }

    private void print(ListNode head) {
        if (head == null)
            return;
        print(head.next);
        list.add(head.val);
    }
}

