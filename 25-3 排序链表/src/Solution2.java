/**
 * @author: Song Ningning
 * @date: 2020-08-17 22:03
 */
public class Solution2 {
    /**
     * 归并排序（自底向上直接合并）
     *
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left;
        ListNode right;
        ListNode tail;
        for (int i = 1; i < len; i *= 2) {
            cur = dummy.next;
            tail = dummy;
            while (cur != null) {
                // left 指向该部分第一个节点，但是该节点以及后面的 i-1 个节点还挂在链表中
                left = cur;
                // 执行完下面一行，left 以及其后的 i-1 个节点就被分离，right 指向后面一部分的头节点
                right = split(left, i);
                // 执行完下面一行，right 以及其后的 i-1 个节点就被分离，cur 指向后面一部分的头节点
                cur = split(right, i);
                // 至此，分离出来两段长为 i 的链表，头节点分别是 left 和 right，下面进行合并
                // 让 tail 指向合并后的头节点，即挂接到前面的链表上
                tail.next = merge(left, right);
                // 然后让 tail 走到链表最后
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    /**
     * 将以 head 开头的链表的前 n 个分离
     * <p>
     * 例如：1 -> 2 -> 3 -> null，n=1；
     * 该方法会使得：1 -> null， 2 -> 3 -> null，返回 2
     * @param head
     * @param n
     * @return 分离后的剩余部分
     */
    private ListNode split(ListNode head, int n) {
        while (--n != 0 && head != null) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode rest = head.next;
        head.next = null;
        return rest;
    }

    // merge
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode node = s.sortList(head);
        while (node != null) {
            System.out.println(node.val + " ");
        }
    }
}
