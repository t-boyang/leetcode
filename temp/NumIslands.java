public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid, m, n);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] grid, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= m) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid, m, n);
        dfs(i, j + 1, grid, m, n);
        dfs(i - 1, j, grid, m, n);
        dfs(i, j - 1, grid, m, n);
    }
}
