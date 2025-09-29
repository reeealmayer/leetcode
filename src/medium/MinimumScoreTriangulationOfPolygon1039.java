package medium;

public class MinimumScoreTriangulationOfPolygon1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        // длина подотрезка
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // пробуем все варианты разбиения
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k][j] + values[i]*values[j]*values[k]);
                }
            }
        }

        return dp[0][n-1];
    }
}
