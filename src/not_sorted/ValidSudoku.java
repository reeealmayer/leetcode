package not_sorted;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];

                if (r != '.') {
                    if (row.contains(r)) {
                        return false;
                    } else {
                        row.add(r);
                    }
                }

                char c = board[j][i];
                if (c != '.') {
                    if (col.contains(c)) {
                        return false;
                    } else {
                        col.add(c);
                    }
                }

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                char b = board[rowIndex + j / 3][colIndex + j % 3];
                if (b != '.') {
                    if (box.contains(b)) {
                        return false;
                    } else {
                        box.add(b);
                    }
                }
            }
        }

        return true;
    }
}
