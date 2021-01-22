public class Solve {
    private int rows;
    private int columns;

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        rows = board.length;
        columns = board[0].length;
        for (int i = 0; i < columns; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[rows - 1][i] == 'O') {
                dfs(board, rows - 1, i);
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][columns - 1] == 'O') {
                dfs(board, i, columns - 1);
            }
        }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '?') {
                    board[i][j] = 'O';
                }
            }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= columns) {
            return;
        }
        if (board[i][j] == '?' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '?';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] data = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        new Solve().solve(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
