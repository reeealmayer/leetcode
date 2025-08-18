package hard;

import java.util.ArrayList;
import java.util.List;

public class Game679 {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double) c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.getFirst() - 24) < 1e-6;
        }

        int n = nums.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }

                double a = nums.get(i);
                double b = nums.get(j);

                List<Double> candidates = new ArrayList<>();
                candidates.add(a + b);
                candidates.add(a - b);
                candidates.add(b - a);
                candidates.add(a * b);
                if (Math.abs(b) > 1e-6) {
                    candidates.add(a / b);
                }
                if (Math.abs(a) > 1e-6) {
                    candidates.add(b / a);
                }

                for (double c : candidates) {
                    next.add(c);
                    if (solve(next)) {
                        return true;
                    }
                    next.removeLast();
                }
            }
        }
        return false;
    }
}
