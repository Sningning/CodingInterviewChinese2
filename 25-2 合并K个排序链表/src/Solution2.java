/**
 * @author: Song Ningning
 * @date: 2020-08-11 19:36
 */
public class Solution2 {

    /**
     * 分治
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        return mergeKLists(lists, 0, len - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + ((hi - lo) >>> 1);
        ListNode l1 = mergeKLists(lists, lo, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    // 复用合并两排序链表代码
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
