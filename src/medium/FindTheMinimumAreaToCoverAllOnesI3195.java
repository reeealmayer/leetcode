package medium;

public class FindTheMinimumAreaToCoverAllOnesI3195 {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int minRow = m;
        int maxRow = -1;
        int minCol = n;
        int maxCol = -1;

        // Проходим по всем клеткам
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        // Если нет единиц — площадь 0
        if (maxRow == -1) return 0;

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}
