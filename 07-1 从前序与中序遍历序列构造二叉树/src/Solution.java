import java.util.HashMap;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 与力扣 105 题 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @Author: Song Ningning
 * @Date: 2020-05-16 19:23
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null) {
            return null;
        }
        
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new IllegalArgumentException("Incorrect input data.");
        }

        // 为了快速定位根节点在 inorder 中位置，使用 map 先存起来
        // 题目中说不含重复元素，所以可以把值作为 key，索引作为 value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    /**
     * 构建二叉树
     * @param preorder 前序遍历序列
     * @param preL 前序遍历序列的左侧边界
     * @param preR 前序遍历序列的右侧边界
     * @param inL 中序遍历序列的左侧边界
     * @param inR 中序遍历序列的右侧边界
     * @param map 记录节点值和节点在中序遍历序列中的索引
     * @return 构建完成的二叉树的根节点
     */
    private TreeNode build(int[] preorder, int preL, int preR,
                           int inL, int inR, HashMap<Integer, Integer> map) {

        if (preL > preR || inL > inR) {
            return null;
        }
        // 根节点的值
        int pivot = preorder[preL];
        // 根节点在中序遍历序列中的位置
        int pivotIdx = map.get(pivot);
        TreeNode root = new TreeNode(pivot);
        // 构建左子树
        root.left = build(preorder, preL + 1, preL + (pivotIdx - inL),
                inL, pivotIdx - 1, map);
        // 构建右子树
        root.right = build(preorder, preL + (pivotIdx - inL) + 1, preR,
                pivotIdx + 1, inR, map);
        return root;
    }
}
