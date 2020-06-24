import java.util.Arrays;

/**
 * @Author: Song Ningning
 * @Date: 2020-06-24 10:44
 */
public class Solution2 {

    /**
     * 使用库函数 Arrays.sort(T[] a, Comparator<? super T> c)
     *
     * 首先将 m 和 n 转换为字符串，然后拼接为 mn 和 nm；
     *     如果 mn.compareTo(nm) < 0，表示 m 小；
     *     如果 mn.compareTo(nm) > 0，表示 n 小；
     *     如果 mn.compareTo(nm) = 0，表示 m 和 n 相等；
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {3,30,34,5,9};
        System.out.println(s.minNumber(arr)); // "3033459"
    }
}
