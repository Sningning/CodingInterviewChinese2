/**
 * 剑指 Offer 55 - I. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 提示：
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @Author: Song Ningning
 * @Date: 2020-07-01 15:32
 */
public class Solution1 {

    /**
     * 递归（DFS）
     * 时间复杂度：O(N)；
     * 空间复杂度：最坏情况退化为链表，树的高度为N，空间复杂度O(N)；
     *          最好情况下完全平衡，树的高度logN，空间复杂度O(logN)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
