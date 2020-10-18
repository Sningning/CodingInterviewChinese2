/**
 * 面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *
 * @author: Song Ningning
 * @date: 2020-05-18 22:18
 */
public class Solution {

    boolean[][] visited;
    int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int x, int y, String word, int index) {
        if (index == word.length() - 1)
            return board[x][y] == word.charAt(index);

        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && search(board, newX, newY, word, index + 1))
                    return true;
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
