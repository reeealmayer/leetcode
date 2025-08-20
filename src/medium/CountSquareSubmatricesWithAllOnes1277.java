package medium;

public class CountSquareSubmatricesWithAllOnes1277 {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {  // только если клетка == 1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // первая строка или колонка
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                    total += dp[i][j];
                }
            }
        }

        return total;
//        0 1 0 0
//        0 1 1 0
//        0 1 1 0
//
//        0 1 0 0
//        0 1 1 0
//        0 1 2 0
    }

    public static void main(String[] args) {

    }
}
