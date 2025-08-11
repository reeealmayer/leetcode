package medium;

import java.util.ArrayList;
import java.util.List;

public class RangeProductQueriesOfPowers2438 {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1000000007;
        List<Integer> powList = new ArrayList<>();
        while (n > 0) {
            int lowBit = n & -n;
            powList.add(lowBit);
            n ^= lowBit;
        }
        int size = powList.size();
        int[][] prodTable = new int[size][size];
        for (int row = 0; row < size; row++) {
            prodTable[row][row] = powList.get(row);
            for (int col = row + 1; col < size; col++) {
                prodTable[row][col] = (int) ((long) prodTable[row][col - 1] * powList.get(col) % MOD);
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prodTable[left][right];
        }
        return result;
    }
}
