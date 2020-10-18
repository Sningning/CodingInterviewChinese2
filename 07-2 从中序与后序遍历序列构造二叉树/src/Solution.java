import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author: Song Ningning
 * @date: 2020-07-16 19:23
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null) {
            return null;
        }

        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            throw new IllegalArgumentException("Incorrect input data.");
        }

        // 为了快速定位根节点在 inorder 中位置，使用 map 先存起来
        // 题目中说不含重复元素，所以可以把值作为 key，索引作为 value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postLen - 1, 0, inLen - 1, map);
    }

    /**
     * 构建二叉树
     * @param postorder 后序遍历序列
     * @param postL 后序遍历序列的左侧边界
     * @param postR 后续遍历序列的右侧边界
     * @param inL 中序遍历序列的左侧边界
     * @param inR 中序遍历序列的右侧边界
     * @param map 记录节点值和节点在中序遍历序列中的索引
     * @return 构建完成的二叉树的根节点
     */
    private TreeNode build(int[] postorder, int postL, int postR,
                           int inL, int inR, HashMap<Integer, Integer> map) {

        if (postL > postR || inL > inR) {
            return null;
        }
        // 根节点的值
        int pivot = postorder[postR];
        // 根节点在中序遍历序列中的位置
        int pivotIdx = map.get(pivot);
        TreeNode root = new TreeNode(pivot);
        // 构建右子树
        root.right = build(postorder, postR - (inR - pivotIdx), postR - 1,
                pivotIdx + 1, inR, map);
        // 构建左子树
        root.left = build(postorder, postL, postR - (inR - pivotIdx) - 1,
                inL, pivotIdx - 1, map);
        return root;
    }
}
