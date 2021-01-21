import java.util.HashMap;
import java.util.Map;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 && board[0].length == 0) {
            return false;
        }
        Map<Character, Integer> rows[] = new HashMap[9];
        Map<Character, Integer> columns[] = new HashMap[9];
        Map<Character, Integer> boxs[] = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    char data = board[i][j];
                    int index = (i / 3) * 3 + j / 3;
                    int r = rows[i].getOrDefault(data, 0);
                    int c = columns[j].getOrDefault(data, 0);
                    int b = boxs[index].getOrDefault(data, 0);
                    if (r >= 1 || c >= 1 || b >= 1) {
                        return false;
                    }
                    rows[i].put(data, 1);
                    columns[j].put(data, 1);
                    boxs[index].put(data, 1);
                }
            }
        return true;
    }
}
