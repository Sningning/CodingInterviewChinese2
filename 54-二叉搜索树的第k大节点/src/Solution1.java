/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:                                 示例 2:
 * 输入: root = [3,1,4,null,2], k = 1      输入: root = [5,3,6,2,4,null,null,1], k = 3
 *    3                                           5
 *   / \                                         / \
 *  1   4                                       3   6
 *   \                                         / \
 *    2                                      2   4
 * 输出: 4                                   /
 *                                         1      输出: 4
 *
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @Author: Song Ningning
 * @Date: 2020-07-01 10:24
 */
public class Solution1 {

    /**
     * BST 中序遍历结果为递增序列，如果知道树的结点总数 n，那么，只需中序遍历到第 n-k+1 个结点即可。
     * 但是并不知道结点总数 n，因此可以从后往前考虑。
     * BST 的中序遍历结果为递增序列；那么中序遍历结果的倒序即为递减序列。
     * 如何得到中序遍历结果的倒序？在递归解法中，中序遍历的顺序为：左->根->右；只需调换下遍历左右子树的
     * 顺序：右->根->左，即可得到递减的序列。
     */
    
    int count;
    int res;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (count == 1) {
            res = root.val;
            // 这里再进减一次防止上一层又会进入 if (count == 1) 判断
            // count == 1 全局只会出现一次
            count--;
            return;
        }
        count--;
        dfs(root.left);
    }
}
