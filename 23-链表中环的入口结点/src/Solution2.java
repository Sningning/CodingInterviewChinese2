/**
 * 面试题23. 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 注意：本题与力扣 142. 环形链表 II 相同
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-03 10:13
 */
public class Solution2 {

    /*
     * 快慢指针
     * Time：O(N)
     * Space：O(1)
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
