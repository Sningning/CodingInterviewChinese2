/**
 * @author: Song Ningning
 * @date: 2020-08-26 16:37
 */
public class Test {

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int[][] operators = {
                {1,1,1},
                {1,2,2},
                {1,3,2},
                {2,1},
                {1,4,4},
                {2,2}
        };
        int k = 3;
        int[] ints = s2.LRU(operators, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
