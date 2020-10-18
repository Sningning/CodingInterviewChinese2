/**
 * 面试题26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A 中有出现和 B 相同的结构和节点值。
 *
 * 限制：
 * 0 <= 节点个数 <= 10000
 *
 * @author: Song Ningning
 * @date: 2020-06-05 10:02
 */
public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 因为空树不是任意一个树的子结构，所以只要有一个为空，就不能构成子树
        if (A == null || B == null)
            return false;
        // 考虑当前节点情况
        if (recur(A, B))
            return true;
        // 如果当前节点匹配不上，考虑 A 的左右孩子与 B 匹配
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 判断当前以 b 为根节点的二叉树是否是以 a 为根节点的二叉树的子树
     * 只考虑当前 a 和 b 匹配情况
     * @param a 根节点 a
     * @param b 根节点 b
     * @return b 是否是 a 的子树
     */
    private boolean recur(TreeNode a, TreeNode b) {

        // b 已经找完了，返回 true
        if (b == null) return true;
        // B 还没找完，A 已经空了，返回 false
        if (a == null) return false;
        // 如果两棵树根节点值不相等，肯定匹配不上
        if (a.val != b.val) return false;
        // 如果两棵树根节点值相等，再去看看各自左右子树匹配情况
        return recur(a.left, b.left) && recur(a.right, b.right);

    }
}
