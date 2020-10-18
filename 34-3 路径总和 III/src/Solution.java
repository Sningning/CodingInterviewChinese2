import java.util.HashMap;

/**
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * @author: Song Ningning
 * @date: 2020-09-09 23:09
 */
public class Solution {

    /**
     * 前缀和 + 回溯
     *
     */
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        // key 是前缀和, value 是大小为 key 的前缀和出现的次数
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        // 如果根节点的值即为目标值，dfs 时 curSum += node.val 为 target，pre = 0，所以默认值为 1
        prefixSumCount.put(0, 1);
        dfs(root, sum, 0, prefixSumCount);
        return res;
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点，有且仅有一条路径，因为这是一棵树
     * 如果当前节点到根节点路径的和为 curSum, 目标为 target，只需看之前的前缀和中有没有 curSum-target 即可
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param node 当前节点
     * @param target 目标值
     * @param curSum 当前路径和
     * @param prefixSumCount 前缀和Map
     */
    private void dfs(TreeNode node, int target, int curSum, HashMap<Integer, Integer> prefixSumCount) {
        if (node == null) {
            return;
        }
        // 将当前节点的值加入 curSum
        curSum += node.val;

        // pre 即为需要往回找的前缀和
        int pre = curSum - target;

        // 查看当前 map 中有无该前缀和 pre，将结果加入到 res
        res += prefixSumCount.getOrDefault(pre, 0);

        // 将当前的前缀和出现的次数 + 1
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        // 递归去左右字数中寻找
        dfs(node.left, target, curSum, prefixSumCount);
        dfs(node.right, target, curSum, prefixSumCount);

        // 回溯，将当前的前缀和出现的次数恢复
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
    }
}
