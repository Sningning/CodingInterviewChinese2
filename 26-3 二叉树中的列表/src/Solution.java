/**
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 *
 * @author: Song Ningning
 * @date: 2020-08-14 9:57
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (dfs(head, root)) {
            return true;
        }
        // 如果两棵树根结点值相等，再去看看各自左右子树匹配情况
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        // 链表走完了，返回true
        if (head == null) {
            return true;
        }
        // 链表没走完，树走完了，返回false
        if (root == null) {
            return false;
        }
        // 如果两棵树根结点值不相等，肯定匹配不上
        if (head.val != root.val) {
            return false;
        }
        // 如果两棵树根结点值相等，再去看看左右子树匹配情况，这里是 或 连接
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}
