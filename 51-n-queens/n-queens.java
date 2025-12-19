import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();
    boolean[] col;
    boolean[] d1;
    boolean[] d2;

    public List<List<String>> solveNQueens(int n) {

        col = new boolean[n];
        d1 = new boolean[2 * n];
        d2 = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        solve(0, n, board);
        return ans;
    }

    void solve(int row, int n, char[][] board) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(new String(board[i]));
            ans.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || d1[row - c + n] || d2[row + c])
                continue;

            board[row][c] = 'Q';
            col[c] = true;
            d1[row - c + n] = true;
            d2[row + c] = true;

            solve(row + 1, n, board);

            board[row][c] = '.';
            col[c] = false;
            d1[row - c + n] = false;
            d2[row + c] = false;
        }
    }
}
