/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @Author: Song Ningning
 * @Date: 2020-07-01 17:07
 */
public class Solution {

    /**
     * 本来直接把最大深度代码 copy 过来，然后 max 改为 min，提交，失败。
     * 仔细审题很重要啊，题目中说了从根节点到最近【叶子节点】，而叶子节点是【没有孩子】的节点。
     * 举个例子：
     *   1
     *    \
     *     2
     * 1 不是叶子节点，2 是叶子节点，所以最小深度是 1 到 2 的深度，为 2，而不是 1
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果到达了叶子节点，直接返回 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = minDepth1(root.left);
        int rightDepth = minDepth1(root.right);
        // 如果 root 只有左孩子或只有右孩子
        // 应该返回较大的那个孩子的深度 + 1
        if (root.left == null || root.right == null) {
            return root.left == null ? rightDepth + 1 : leftDepth + 1;
        }
        // 如果左右孩子均不为空，返回较小的一个 + 1
        return Math.min(leftDepth, rightDepth) + 1;
    }


    /**
     * 因为 null 也是节点，所以可以再递归一层
     * 如果左孩子为空的话，leftDepth = 0；
     * 如果右孩子为空的话，rightDepth = 0；
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth2(root.left);
        int rightDepth = minDepth2(root.right);

        // 判断当前节点是不是叶子节点

        // 如果左孩子和右孩子其中一个为空，那么需要返回较大的那个孩子的深度 + 1
        //   如果其中一个节点为空，说明 leftDepth 和 rightDepth 有一个必然为 0，所以可以返回 leftDepth + rightDepth + 1
        // 如果都为空(当前节点为叶子节点)，那么直接返回 1
        //   如果都为空，leftDepth 和 rightDepth 都为 0，还是可以返回 leftDepth + rightDepth + 1
        if (root.left == null || root.right == null) {
            return leftDepth + rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth);
    }
}
