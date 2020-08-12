/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * @author: Song Ningning
 * @date: 2020-08-12 12:28
 */
public class Solution {

    /**
     * 与上一题不同之处在于，这里是子树，并不是子结构，根据示例 2 可知，即使节点都对应上了，
     * 但是 s 中节点 4 的子树还包括节点 0，而 t 中不包含节点 0，因此返回 false。
     */

    public boolean isSubtree(TreeNode s, TreeNode t) {
        // t 为 null 一定 true
        if (s == null && t == null) {
            return true;
        }
        // 如果 t 不为 null, 只要 s 为 null，肯定是 false
        if (s == null || t == null) {
            return false;
        }
        if (dfs(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        // 只有同时为 null 才相等
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
