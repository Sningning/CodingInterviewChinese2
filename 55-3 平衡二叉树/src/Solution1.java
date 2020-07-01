/**
 * 剑指 Offer 55 - III. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 限制：
 * 1 <= 树的结点个数 <= 10000
 *
 * 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @Author: Song Ningning
 * @Date: 2020-07-01 18:15
 */
public class Solution1 {

    /**
     * 从根结点出发，对于每个结点，计算其左右深度，然后判断。
     *
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 求以 root 为根的二叉树的最大深度
     * @param root 根结点
     * @return 二叉树的最大深度
     */
    private int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
