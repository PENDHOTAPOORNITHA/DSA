class Solution {

    boolean[] col;
    boolean[] d1;
    boolean[] d2;
    int count = 0;

    public int totalNQueens(int n) {

        col = new boolean[n];
        d1 = new boolean[2 * n];
        d2 = new boolean[2 * n];

        solve(0, n);
        return count;
    }

    void solve(int row, int n) {

        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || d1[row - c + n] || d2[row + c])
                continue;

            col[c] = true;
            d1[row - c + n] = true;
            d2[row + c] = true;

            solve(row + 1, n);

            col[c] = false;
            d1[row - c + n] = false;
            d2[row + c] = false;
        }
    }
}
