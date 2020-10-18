/**
 * 面试题33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 提示：
 * 数组长度 <= 1000
 *
 * @author: Song Ningning
 * @date: 2020-06-09 16:39
 */
public class Solution1 {

    /**
     * 递归分治
     *
     * 后序遍历序列中，最后一个数是 root，postorder[0...len-2] 可以分成两部分，root 的左子树和右子树；
     * 因为是 BST，故左子树小于 root，右子树的值大于 root。
     * 所以，在 postorder[0...len-2] 中找到分界点 k，k 是第一个大于 root 的数，
     *     postorder[0...k-1] 是 root 的左子树，postorder[k...len-2] 是 root 的右子树；
     * 然后递归判断 postorder[0...k-1] 和 postorder[k...len-2] 两部分。
     *
     * 递归终止条件：区间只有 1 个元素时，返回 true
     * 递归过程：
     *     针对某一序列 postorder，p1 指向 0 位置元素，p2 指向最后一个位置元素；
     *     1. 划分左右子树：
     *         遍历 postorder[p1...p2]，找到第一个大于根节点的节点，索引记为 k，
     *         此时划分为左子树区间 [p1...k-1]、右子树区间[k...p2-1]
     *     2. 判断是否是 BST
     *         左子树区间 [p1...k-1]：postorder[p1...k-1] 全部元素必须小于 postorder[p2]，这在上一步已经保证了，因此不需要判断；
     *         右子树区间 [k...p2-1]：postorder[k...p2-1] 全部元素必须大于 postorder[p2]，可以遍历该范围来判断。
     * 返回值：必须每个区间都是满足条件才返回 true
     *
     */
    public static boolean verifyPostorder(int[] postorder) {
        return verifySeq(postorder, 0, postorder.length - 1);
    }

    private static boolean verifySeq(int[] postorder, int p1, int p2) {
        if (p1 >= p2)
            return true;
        // 找到第一个大于根节点的节点，索引记为 k
        int k = p1;
        while (postorder[k] < postorder[p2]) k++;
        // 判断右区间
        for (int i = k; i < p2; i++) {
            if (postorder[i] <= postorder[p2])
                return false;
        }
        return verifySeq(postorder, p1, k - 1) && verifySeq(postorder, k, p2 - 1);  // 注意最后应该是 p2-1
    }

    /*
    // 稍微简洁点的写法
    private static boolean verifySeq(int[] postorder, int p1, int p2) {
        if (p1 >= p2)
            return true;
        int k = p1;
        while (postorder[k] < postorder[p2]) k++;
        int m = k;
        while (postorder[k] > postorder[p2]) k++;
        return k == p2 && verifySeq(postorder, p1, m - 1) && verifySeq(postorder, m, p2 - 1);
    }
     */

    public static void main(String[] args) {
        int[] arr1 = {1,6,3,2,5};
        System.out.println(verifyPostorder(arr1));
        int[] arr2 = {1,3,2,6,5};
        System.out.println(verifyPostorder(arr2));
    }
}
