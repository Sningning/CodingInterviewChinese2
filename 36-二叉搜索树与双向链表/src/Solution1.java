/**
 * 面试题36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @Author: Song Ningning
 * @Date: 2020-06-14 12:47
 */
public class Solution1 {

    /**
     * 中序遍历 + 两个全局变量构建链表
     *
     * 关键点：二叉搜索树、排序循环双向链表
     * 排序链表：BST 的中序遍历的结果是有序的，因此遍历树的方法时中序遍历；
     * 双向链表：不仅需要 cur.left = left，还需要 left.right = cur
     * 循环链表：head.left = tail, tail.right = head
     *
     * Time：O(N) 把所有节点遍历一遍
     * Space：O(N) 最坏的情况下退化成链表，递归深度达到 N，需要 O(N) 系统栈。
     */

    Node prev, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        // 运行完 dfs(root) 后，prev 指向链表最后一个节点
        // 完成头尾节点的连接
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (prev == null) {
            // 走到了最左侧，头节点即为当前节点
            head = cur;
        } else {
            // 双向连接
            prev.right = cur;
            cur.left = prev;
        }
        prev = cur;
        dfs(cur.right);
    }
}
