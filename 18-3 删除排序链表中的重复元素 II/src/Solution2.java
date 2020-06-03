/**
 * @Author: Song Ningning
 * @Date: 2020-06-03 11:41
 */
public class Solution2 {

    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val)
                // 去重
                head = head.next;
            return deleteDuplicates(head.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
