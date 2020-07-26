/**
 * @author: Song Ningning
 * @date: 2020-07-26 17:15
 */
public class Solution3 {

    /**
     * 首先遍历链表，统计节点个数，再遍历链表，将节点数组从后往前插入数组。
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        int[] res = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
