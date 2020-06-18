/**
 * @Author: Song Ningning
 * @Date: 2020-06-18 14:52
 */
public class Solution3 {

    /**
     * Top K 问题另一个解法是 【快速选择】，快速选择是快速排序的变形。
     * 快速排序每次都会选定 pivot，将数组划分为 [< pivot, pivot, > pivot] 三部分，该过程称为 partition。
     * 然后对【小于 pivot】和【大于 pivot】两部分递归划分。
     * 假设当前 pivot 的下标为 m，则当前数组左侧的 j 个元素是整个数组中最小的 j 个数，和 k 进行比较，有 3 种情况：
     *     ① j < k：说明左侧的 j 个数是最后答案的一个子集，另外的 k-j 个数需要去右侧寻找，因此只需要对右侧数组进行 partition；
     *       （因为最后返回并不要求是有序的，所以左侧部分不需要继续 partition）
     *     ② j > k：说明最后的答案是左侧部分的一个子集，为了排除那 j-k 个元素，需要对左侧部分进行 partition；
     *     ③ j == k：说明左侧部分刚好有 k 个，而这个 k 个元素就是整个数组中最小的 k 个元素，返回左侧部分数组即可。
     *
     *
     * 两种方法的优劣性比较
     * 在面试中，另一个常常问的问题就是这两种方法有何优劣。
     * 看起来分治法的快速选择算法的时间、空间复杂度都优于使用堆的方法，但是要注意到快速选择算法的几点局限性：
     *
     * 第一，算法需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度就上去了。
     * 第二，算法需要保存所有的数据。如果把数据看成输入流的话，使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k 个元素的最大堆。
     *      而快速选择的方法需要先保存下来所有的数据，再运行算法。当数据量非常大的时候，甚至内存都放不下的时候，就麻烦了。
     *      所以当数据量大的时候还是用基于堆的方法比较好。
     *
     * 作者：nettee
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
     */
    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }
        // 快速选择
        quickSelect(arr, 0, arr.length - 1, k);
        // 存入结果集
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSelect(int[] arr, int lo, int hi, int k) {
        int j = partition(arr, lo, hi);
        if (j == k) {
            return;
        } else if (j < k) {
            quickSelect(arr, j + 1, hi, k);
        } else { // j > k
            quickSelect(arr, lo, j - 1, k);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int p = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && arr[i] < p);
            while (--j >= lo && arr[j] > p);
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr1 = {3,2,1};
        int[] arr2 = {0,1,2,1};
        int[] res1 = s.getLeastNumbers(arr1, 2);
        for (int num : res1) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] res2 = s.getLeastNumbers(arr2, 1);
        for (int num : res2) {
            System.out.print(num + " ");
        }
    }
}
