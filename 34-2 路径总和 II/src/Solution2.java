import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Song Ningning
 * @Date: 2020-06-12 16:09
 */
public class Solution2 {

    /**
     * 上面的解法，在 backtrack 函数中，递归终止的条件比较繁琐，因为是只递归到叶子节点，
     * 其实完全可以递归到空
     */

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> path = new LinkedList<>();
        backtrack(root, sum, path);
        return res;
    }

    private void backtrack(TreeNode node, int sum, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new LinkedList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // 到了此处，node 可能是不满足条件的叶子节点，那么进入下面两个递归都是直接 return 了；
        // 也可能是非叶子节点，继续完成递归。
        backtrack(node.left, sum - node.val, path);
        backtrack(node.right, sum - node.val, path);
        path.remove(path.size() - 1);
    }


    /**
     * 也可以删掉 path.remove(path.size() - 1); return;
     * 因为是叶子节点了，再递归进去的话，其实也是直接 return，然后最后再执行一次 path.remove(path.size() - 1);
     * 精简两行以后相当于多递归了一层
     */
    private void backtrack1(TreeNode node, int sum, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new LinkedList<>(path));
        }
        // 到了此处，node 可能是不满足条件的叶子节点，那么进入下面两个递归都是直接 return 了；
        // 也可能是非叶子节点，继续完成递归。
        backtrack(node.left, sum - node.val, path);
        backtrack(node.right, sum - node.val, path);
        path.remove(path.size() - 1);
    }
}
