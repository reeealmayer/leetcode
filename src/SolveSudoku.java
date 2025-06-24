public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col <= 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num < '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }

            int blockRow = 3 * (row / 3) + i / 3;
            int blockCol = 3 * (col / 3) + i % 3;
            if (board[blockRow][blockCol] == num) {
                return false;
            }
        }
        return true;
    }
}
