/**
 * 面试题28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与力扣 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author: Song Ningning
 * @date: 2020-06-06 19:17
 */
public class Solution1 {

    // 递归

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        // 传入的两个节点均为空，返回 true
        if (node1 == null && node2 == null)
            return true;
        // 如果一个为空一个不为空，返回 false
        if (node1 == null || node2 == null)
            return false;

        // 两个节点都不为空，但是值不相等返回 false
        if (node1.val != node2.val)
            return false;
        // 传入的两个节点值相等的话，再递归往下看
        return check(node1.left, node2.right) && check(node1.right, node2.left);

        // 最后的 if-else 可以简写
        // return (node1.val == node2.val) && (check(node1.left, node2.right) && check(node1.right, node2.left));
    }
}
