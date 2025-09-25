package hard;

import java.util.Arrays;

public class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int smallest = 1;

        for (int num : nums) {
            if (num == smallest) {
                smallest++;
            }
        }

        return smallest;
    }
}
