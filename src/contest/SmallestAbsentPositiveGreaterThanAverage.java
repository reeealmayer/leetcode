package contest;

import java.util.HashSet;
import java.util.Set;

public class SmallestAbsentPositiveGreaterThanAverage {
    public static int smallestAbsent(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        int sum = 0;
        for (int i : nums) {
            sum += i;
            hashSet.add(i);
        }
        int averageArithmetic = sum / nums.length;
        System.out.println(averageArithmetic);
        if (averageArithmetic < 0) {
            averageArithmetic = 0;
        }
        for (int i = averageArithmetic + 1; i < Integer.MAX_VALUE; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(smallestAbsent(new int[]{1, -39, 9}));
    }
}
