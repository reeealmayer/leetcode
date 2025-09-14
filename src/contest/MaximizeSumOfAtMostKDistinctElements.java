package contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MaximizeSumOfAtMostKDistinctElements {
    public static int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> biggestDigits = new HashSet<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!biggestDigits.contains(nums[i])) {
                biggestDigits.add(nums[i]);
                if (biggestDigits.size() == k) {
                    return biggestDigits.stream()
                            .sorted(Comparator.reverseOrder())   // сортировка по убыванию
                            .mapToInt(Integer::intValue)         // перевод в int
                            .toArray();
                }
            }
        }
        return biggestDigits.stream()
                .sorted(Comparator.reverseOrder())   // сортировка по убыванию
                .mapToInt(Integer::intValue)         // перевод в int
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxKDistinct(new int[]{1}, 1)));
    }
}
