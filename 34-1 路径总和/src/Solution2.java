/**
 * @Author: Song Ningning
 * @Date: 2020-06-12 11:48
 */
public class Solution2 {

    /**
     * 可以把 Solution1 中 helper 的情况合并下，这样递归终止的条件可以设置为 2 个：
     *   1. 到达了叶子节点；
     *   2. 当前节点为空，返回 false
     * 对于当前考虑的节点为空的话有 2 种情况：
     *   1. 根节点，直接返回 false；
     *   2. 一个节点传入的空的左节点或右节点，对应于下面这种情况：
     *        1
     *       /
     *      2
     *    1 节点将其右孩子传入递归函数，由于 1 不是子节点，因此右侧的判断也会终止。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 已经到达了叶子节点，可以判断了
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        // 运行到这里，root 可能有左右孩子，也可能只有一个孩子
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
