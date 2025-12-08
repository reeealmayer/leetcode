package easy;

import java.util.HashSet;
import java.util.Set;

public class CountSquareSumTriples1925 {
    public static int countTriples(int n) {
        int[] arr = new int[n];
        int result = 0;
        Set<Integer> squares = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = (i + 1) * (i + 1);
            squares.add((i + 1) * (i + 1));
        }

        for (int x : arr) {
            for (int y : arr) {
                if (x != y && squares.contains(x + y)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countTriples(5));
    }
}
