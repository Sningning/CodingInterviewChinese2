/**
 * @author: Song Ningning
 * @date: 2020-08-01 19:13
 */
public class Solution2 {
    /**
     * 迭代的另一种代码
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            ListNode cur = prev.next;
            while (cur != null && prev.next.val == cur.val) {
                cur = cur.next;
            }
            if (prev.next.next == cur) {
                // 说明 cur 没有经历重复节点
                prev = prev.next;
            } else {
                // 说明 cur 经历了重复节点
                // 不能直接让 prev = cur，因为 cur 当前指向的节点可能和后面重复
                prev.next = cur;
            }
        }
        return dummy.next;
    }
}
