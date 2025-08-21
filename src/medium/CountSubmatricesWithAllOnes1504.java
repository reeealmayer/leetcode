package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubmatricesWithAllOnes1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] height = new int[m][n];

        // Заполняем "высоты" как в гистограмме
        for (int j = 0; j < n; j++) {
            height[0][j] = mat[0][j];
            for (int i = 1; i < m; i++) {
                height[i][j] = (mat[i][j] == 1) ? height[i - 1][j] + 1 : 0;
            }
        }

        int res = 0;
        // Для каждой строки считаем кол-во прямоугольников
        for (int i = 0; i < m; i++) {
            res += countRectangles(height[i]);
        }
        return res;
    }

    // Считаем кол-во подпрямоугольников в "гистограмме"
    private int countRectangles(int[] h) {
        int n = h.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] sum = new int[n]; // sum[j] хранит кол-во прямоугольников с правой границей в j

        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[j]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + h[j] * (j - prev);
            } else {
                sum[j] = h[j] * (j + 1);
            }

            res += sum[j];
            stack.push(j);
        }
        return res;
    }
}
