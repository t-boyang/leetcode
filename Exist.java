public class Exist {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visit = new boolean[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (backTrace(0, i, j, board, word, visit) == true) {
                    return true;
                }
            }
        return false;
    }

    private boolean backTrace(int k, int i, int j, char[][] board, String word, boolean[][] visit) {
        int rows = board.length;
        int columns = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= columns) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (visit[i][j] == true) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visit[i][j] = true;
        boolean flag = backTrace(k + 1, i + 1, j, board, word, visit) || backTrace(k + 1, i - 1, j, board, word, visit)
                || backTrace(k + 1, i, j + 1, board, word, visit) || backTrace(k + 1, i, j - 1, board, word, visit);
        visit[i][j] = false;
        return flag; // !
    }

    public static void main(String[] args) {
        char[][] data = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(new Exist().exist(data, "ABCB"));
    }
}
