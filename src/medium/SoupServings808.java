package medium;

public class SoupServings808 {
    private double[][] memo;

    public double soupServings(int n) {
        // Быстрая эвристика: для очень больших n ответ ≈ 1
        if (n >= 4800) return 1.0;

        // Переводим в единицы по 25 мл (округление вверх)
        int N = (n + 24) / 25;
        memo = new double[N + 1][N + 1];

        // Инициализируем -1 как признак невычисленного
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                memo[i][j] = -1.0;
            }
        }

        return prob(N, N);
    }

    private double prob(int a, int b) {
        // базовые случаи
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0 && b > 0) return 1.0;
        if (a > 0 && b <= 0) return 0.0;

        if (memo[a][b] >= 0) return memo[a][b];

        double res = 0.0;
        // операции в единицах по 25 мл: (A, B)
        int[][] ops = new int[][]{{4, 0}, {3, 1}, {2, 2}, {1, 3}};

        for (int[] op : ops) {
            int na = Math.max(0, a - op[0]);
            int nb = Math.max(0, b - op[1]);
            res += 0.25 * prob(na, nb);
        }

        memo[a][b] = res;
        return res;
    }
}
