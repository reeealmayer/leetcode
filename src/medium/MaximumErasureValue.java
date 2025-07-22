package medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> unique = new HashSet<>();

        int currentSum = 0;
        int result = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            while (unique.contains(nums[i])) {
                unique.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            unique.add(nums[i]);
            currentSum += nums[i];
            result = Math.max(currentSum, result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[] {4, 2, 4, 5, 6}));
    }
}
