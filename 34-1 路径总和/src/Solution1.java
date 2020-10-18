/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author: Song Ningning
 * @date: 2020-06-12 9:16
 */
public class Solution1 {

    /**
     * 递归 (DFS)
     *
     * 这道题有个坑，题目中说是否存在根节点到【叶子节点】的路径，也就是说一定要找到叶子节点才算完。
     * 比如上面的例子，如果给定的 sum = 20，有一条路径 5-4-11，相加是 20，但是 11 不是叶子节点，所以这条路径也是 false。
     * 知道这个以后，就明白每次都需要走到叶子节点。
     *
     * 递归终止条件：走到了根节点，可以进行判断了。
     */

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        // 递归终止条件：到达了叶子节点，进行返回
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        // 只有右孩子
        if (root.left == null) {
            return helper(root.right, sum - root.val);
        }
        // 只有左孩子
        if (root.right == null) {
            return helper(root.left, sum - root.val);
        }
        // 既有右孩子又有左孩子
        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
